package com.example.projetofinal.Fragments


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projetofinal.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.second_activity.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.util.*


class FragmentOne : Fragment(){
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




        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search(queryPesquisa!!, years)
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                examples?.let {

                    var array = examples.result.timeline

                    var gson = Gson()
                    var jsonString = gson.toJson(array)


                    var fragmento1 = FragmentTeste1.newInstance(jsonString)
                    //var fragmento1 = FragmentTeste1.newInstance(array?.get(0)!!.headlines as ArrayList<Headline>,array?.get(0)!!.date_interval_end,array?.get(0)!!.date_interval_begin )
                    var fragmento2 = FragmentTeste2()

                    adapter.addFragment(fragmento1, "Narrativa")
                    adapter.addFragment(fragmento2, "Termos Relacionados")
                    view.viewpager.adapter = adapter
                    view.tabs.setupWithViewPager(view.viewpager)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(activity, "Erro no serviço ", Toast.LENGTH_SHORT)
            }
        })

       /* view.shareButton.setOnClickListener {
            val bitmap = loadBitmapFromView(activity!!.window.decorView.rootView)
            saveImage(bitmap)
            share(sharePath)
        }*/
        return view
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

    private fun share(sharePath: String) {
        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        val file = File(sharePath)
        val uri = Uri.fromFile(file)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(intent)

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
}
