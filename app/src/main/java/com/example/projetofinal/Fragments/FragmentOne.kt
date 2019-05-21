package com.example.projetofinal.Fragments


import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.projetofinal.*
import com.example.projetofinal.modelclass.Algo
import com.example.projetofinal.modelclass.Example_Yake
import com.example.projetofinal.modelclass.Wordcloud
import com.google.gson.Gson
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.second_activity.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.concurrent.thread


class FragmentOne : androidx.fragment.app.Fragment(){
    private lateinit var helper: NarrativasHelper
    private var sharePath = "no"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.second_activity, container, false)
        val adapter = ViewPagerAdapter(childFragmentManager)

        helper= NarrativasHelper.instance

        val name1 = arguments?.getString("pesquisa")
        val name2 = arguments?.getInt("anos")
        var queryPesquisa = name1?.replace("\\s".toRegex(),"+")
        var years = ""

        when(name2){
            0 -> years = "5"
            1 -> years = "10"
            2 -> years = "15"
            3 -> years = "20"
            else -> years = "10"
        }

        // ainda n faz nada
        //val service2 = RetrofitClientInstance_Keywords.retrofitInstance?.create(ServiceAPI::class.java)
        //val call2 = service2?.search_words(content,"1","20")
        // acaba aqui

        view.linear_vis.visibility=View.INVISIBLE
        view.spin_kit.visibility=View.VISIBLE
        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search(queryPesquisa!!, years)
        //val call = service?.searchnovo("1dsm62")
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                if(response.message().equals("INTERNAL SERVER ERROR")){
                    withButtonCentered(view)
                    //Toast.makeText(activity,"Erro, tente com outro input",Toast.LENGTH_LONG);
                    //activity!!.onBackPressed()
                }
                if(examples==null){
                    view.linear_vis.visibility=View.VISIBLE
                    view.spin_kit.visibility=View.INVISIBLE
                    // por popup e mandar para o fragmento two
                }
                examples?.let {

                    var array = examples.result.timeline

                    var arrayDeDomains = examples.result.domains
                    var gson = Gson()
                    var jsonString = gson.toJson(array)
                    var jsonStringDomains = gson.toJson(arrayDeDomains)


                    var fragmento1 = FragmentTeste1.newInstance(jsonString, name1!!,years,jsonStringDomains)
                    //var fragmento1 = FragmentTeste1.newInstance(array?.get(0)!!.headlines as ArrayList<Headline>,array?.get(0)!!.date_interval_end,array?.get(0)!!.date_interval_begin )
                    var fragmento2 = FragmentTeste2()

                    adapter.addFragment(fragmento1, "Narrativa")
                    adapter.addFragment(fragmento2, "Termos Relacionados")
                    view.viewpager.adapter = adapter
                    view.tabs.setupWithViewPager(view.viewpager)

                    view.linear_vis.visibility=View.VISIBLE
                    view.spin_kit.visibility=View.INVISIBLE
                    //chamarServico(array!!)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                withButtonCentered(view)
            }
        })

        view.shareButton.setOnClickListener {
            val bitmap = loadBitmapFromView(activity!!.window.decorView.rootView)
            saveImage(bitmap)
            share(sharePath,bitmap,queryPesquisa!!,years)
        }
        return view
    }

    fun chamarServico(array : List<Timeline>){

        thread(start = true) {
            println(array)
            var teste : String = ""
            for(item in array){
                for(item2 in item.headlines.orEmpty()){
                    teste+=item2.keyphrase+" "
                }
            }
            println(teste)


            val service2 = RetrofitClientInstance_Keywords.retrofitInstance?.create(ServiceAPI::class.java)
            val call2 = service2?.search_words(teste,"1","20")
            call2?.enqueue(object : Callback<Example_Yake> {

                override fun onResponse(call: Call<Example_Yake>, response: Response<Example_Yake>) {
                    val gson = Gson()
                    outroServico(gson.toJson(response.body()))
                }

                override fun onFailure(call: Call<Example_Yake>, t: Throwable) {
                    println("edede")
                }
            })
        }
    }


    fun outroServico(algo2 : String){

        println(algo2)
        val service3 = RetrofitWordCloudInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call3 = service3?.search_cloud("300","300",algo2)
        println(call3.toString())
        call3?.enqueue(object : Callback<Wordcloud> {


            override fun onResponse(call: Call<Wordcloud>, response: Response<Wordcloud>) {
                println(response)
                val outronome = response.body()
                println(outronome)

                val decodedstring = Base64.getDecoder().decode(outronome?.wordcloudb64)
                val decodedByte = BitmapFactory.decodeByteArray(decodedstring,0,decodedstring.size)
                val atividade = activity as SecondActivity
                //atividade.imagemtestar.setImageBitmap(decodedByte)
            }

            override fun onFailure(call: Call<Wordcloud>, t: Throwable) {
                println("edede")
            }
        })
    }

    fun saveImage(bitmap: Bitmap) {
        val now = Date()
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)
        val root = Environment.getExternalStorageDirectory().toString()
        val myDir = File(root + "/contamehistorias")
        myDir.mkdirs()
        val fname = now
        val file = File(myDir, "$fname.png")
        sharePath = file.toString()
        if (file.exists())
            file.delete()
        try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadBitmapFromView(v: View): Bitmap {
        // create bitmap screen capture
        v.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(v.drawingCache)
        v.isDrawingCacheEnabled = false
        return bitmap
    }

    private fun share(sharePath: String, bitmap: Bitmap,pesquisa:String , anos:String) {

        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        val file = File(sharePath)
        val uri = Uri.fromFile(file)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.putExtra(Intent.EXTRA_TEXT, "http://contamehistorias.pt/arquivopt/search?query="+pesquisa+"&lastyears="+anos+"&lang_code=pt")
        startActivity(Intent.createChooser(intent,"share image via..."))
    }


    companion object {
        fun newInstance(pesquisa: String, anos: Int): FragmentOne {
            val args = Bundle()
            args.putString("pesquisa", pesquisa)
            args.putInt("anos", anos)
            val fragment = FragmentOne()
            fragment.arguments = args
            return fragment
        }
    }

    fun withButtonCentered(view: View) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage("Não foram encontrados resultados suficientes para a pesquisa efetuada. Tente novamente com outra pesquisa.")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setNeutralButton("Ok") { dialog, which ->
            activity!!.onBackPressed()
        }
        builder.show()
    }



}
