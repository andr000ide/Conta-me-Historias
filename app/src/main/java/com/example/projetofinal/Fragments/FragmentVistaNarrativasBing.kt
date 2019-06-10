package com.example.projetofinal.Fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.frag_searchview.*
import kotlinx.android.synthetic.main.frag_searchview.view.*
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import java.io.Serializable
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.second_activitynew.*
import android.text.style.URLSpan
import android.text.SpannableStringBuilder
import android.text.Html
import android.widget.TextView
import android.text.style.ClickableSpan
import androidx.core.content.ContextCompat
import com.example.projetofinal.*
import com.example.projetofinal.modelclass.Ingles.KeyPhrases
import java.security.Key


class FragmentVistaNarrativasBing : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.frag_searchview, container, false)

        val inicio = arguments?.getString("begin")
        val fim = arguments?.getString("end")

        val jsonArray = arguments?.getString("narrativas")

        val jsonarrayDomains = arguments?.getString("domains")

        var gson = Gson()

        val turnsType = object : TypeToken<List<KeyPhrases>>() {}.type
        var testModel = gson.fromJson<List<KeyPhrases>>(jsonArray, turnsType)

        var query = arguments?.getString("query")

//something
        //view.textview_domains.movementMethod=LinkMovementMethod.getInstance()
        view.textview_domains.highlightColor=Color.TRANSPARENT

        val turnsType2 = object : TypeToken<List<String>>() {}.type
        var testMode2 = gson.fromJson<List<String>>(jsonarrayDomains, turnsType2)

        view.textview_domains.isClickable=true

        var text : String = "Portais de Notícias : "
        for (item in testMode2){
            text= text +item + " "
        }

        view.textview_domains.text=text


        //button para mostrar domains

        view.buttonshowdomains.setOnClickListener {
            if(view.textview_domains.visibility==View.GONE){
                view.textview_domains.visibility=View.VISIBLE
                view.buttonshowdomains.text="-"
            }

            else{
                view.textview_domains.visibility=View.GONE
                view.buttonshowdomains.text="+"
            }
        }


        var arrayNoticias = ArrayList<String>()


        view.recycler_view.setNestedScrollingEnabled(false)
        view.recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            adapter = AdapterNarrativasBing(testModel as ArrayList<KeyPhrases>, context)
        }

        // view.recycler_view.adapter = AdapterNarrativas(arrayNoticias, context!!)

        view.titulo_narrativa.text= query+" - Noticias desde "+ convertedata(inicio!!) + " até " + convertedata(fim!!) +""
        return view

    }

    companion object {
        fun newInstance(narrativas: String,end : String,begin : String,query :String, domains : String): FragmentVistaNarrativasBing {
            val args = Bundle()
            args.putString("begin", begin)
            args.putString("end", end)
            args.putString("narrativas",narrativas)
            args.putString("query",query)
            args.putString("domains",domains)
            val fragment = FragmentVistaNarrativasBing()
            fragment.arguments = args
            return fragment
        }
    }

    fun convertedata(data: String):String{
        val strs = data.split(" ").toTypedArray()

        val aux = strs.get(0)
        //val aux2= aux.takeLast(2)
        return  aux
    }

}
