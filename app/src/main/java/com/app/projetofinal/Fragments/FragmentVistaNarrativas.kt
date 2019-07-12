package com.app.projetofinal.Fragments



import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.frag_searchview.view.*
import android.text.style.URLSpan
import android.text.SpannableStringBuilder
import android.text.Html
import android.widget.TextView
import android.text.style.ClickableSpan
import androidx.core.content.ContextCompat
import com.app.projetofinal.*
import kotlinx.android.synthetic.main.second_activity.view.*
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList


class FragmentVistaNarrativas : androidx.fragment.app.Fragment() {
    private lateinit var langHelper: LangHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.frag_searchview, container, false)


        val inicio = arguments?.getString("begin")
        val fim = arguments?.getString("end")

        val jsonArray = arguments?.getString("headline")

        val jsonarrayDomains = arguments?.getString("domains")
        var years = arguments?.getString("years")


        //val aux = "<a href=\"http://www.google.com\">Google</a><a href=\"http://www.google.com\">Google</a>"
        //val aux = getString(R.string.helpere)

        //view.algo.text=Html.fromHtml(aux)
        //setTextViewHTML(view.algo,aux)


        var gson = Gson()
        val turnsType = object : TypeToken<List<Headline>>() {}.type
        var testModel = gson.fromJson<List<Headline>>(jsonArray, turnsType)
        var query = arguments?.getString("query")

//something
        //view.textview_domains.movementMethod=LinkMovementMethod.getInstance()
       view.textview_domains.highlightColor=Color.TRANSPARENT

        val turnsType2 = object : TypeToken<List<String>>() {}.type
        var testMode2 = gson.fromJson<List<String>>(jsonarrayDomains, turnsType2)

        view.textview_domains.isClickable=true


        val aux = "<a >This is cliclable text  5   </a>" +
                "<a href=\"http://www.xyz-zyyx.com\">This is cliclable text</a> "


        var aux99 = 0
        var text : String = getString(R.string.infor)
        for (item in testMode2){
            if(aux99==0){
                text = text +"<br/>"
            }
            aux99 = 1
            //text= text + " "+"http://"+item + " "
            text = text + "<a href=\""+"http://"+item +"\">"+item+"</a>"+"<br/>"
        }

        //view.textview_domains.text=text
        view.textview_domains.text=Html.fromHtml(text)

       //button para mostrar domains

        view.buttonshowdomains.setOnClickListener {
            if(view.textview_domains.visibility==View.GONE){
                view.textview_domains.visibility=View.VISIBLE
                view.buttonshowdomains.text="-"
                //view.textview_domains.movementMethod = LinkMovementMethod.getInstance()
                //view.textview_domains.text = getString(R.string.helpere)
            }

            else{
                view.textview_domains.visibility=View.GONE
                view.buttonshowdomains.text="+"
            }
        }





        var arrayNoticias = ArrayList<String>()
        /*
        for(item in auxiliar){
            arrayNoticias.add(item.keyphrase)
        }
        */

        view.recycler_view.setNestedScrollingEnabled(false)
        view.recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            adapter = AdapterNarrativas(testModel as ArrayList<Headline>, context!!,activity!!.applicationContext)
        }

       // view.recycler_view.adapter = AdapterNarrativas(arrayNoticias, context!!)

        langHelper = LangHelper(activity!!.applicationContext)

//        if(langHelper.getLanguageSaved().equals("en")) {
//            view.titulo_narrativa.text= query+" - News from "+ inicio + " to " + fim +""
//        }
//        else{
//            view.titulo_narrativa.text= query+" - Noticias desde "+ inicio + " até " + fim +""
//        }

        if(langHelper.getLanguageSaved().equals("en")) {
            //view.titulo_narrativa.text= "Search: "+query
            view.titulo_narrativa.text=Html.fromHtml("Search: "+"<u>"+query+"</u>")
        }
        else{
            view.titulo_narrativa.text=Html.fromHtml("Pesquisa: "+"<u>"+query+"</u>")
        }


        // mudar os anos aqui
        view.shareButton.setOnClickListener {
            share(query!!, years!!)
        }

        return view

        return view

    }

    companion object {
        fun newInstance(headline: String,end : String,begin : String,query :String, domains : String,years : String): FragmentVistaNarrativas {
            val args = Bundle()
            args.putString("begin", begin)
            args.putString("end", end)
            args.putString("headline",headline)
            args.putString("query",query)
            args.putString("domains",domains)
            args.putString("years",years)
            val fragment = FragmentVistaNarrativas()
            fragment.arguments = args
            return fragment
        }
    }

    protected fun setTextViewHTML(text: TextView, html: String) {
        val sequence = Html.fromHtml(html)
        val strBuilder = SpannableStringBuilder(sequence)
        val urls = strBuilder.getSpans(0, sequence.length, URLSpan::class.java)
        for (span in urls) {
            makeLinkClickable(strBuilder, span)
        }
        text.text = strBuilder
        text.movementMethod = LinkMovementMethod.getInstance()
    }

    protected fun makeLinkClickable(strBuilder: SpannableStringBuilder, span: URLSpan) {
        val start = strBuilder.getSpanStart(span)
        val end = strBuilder.getSpanEnd(span)
        val flags = strBuilder.getSpanFlags(span)
        val clickable = object : ClickableSpan() {
            override fun onClick(view: View) {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(span.url))
                ContextCompat.startActivity(activity!!.applicationContext, intent, null)
            }
        }
        strBuilder.setSpan(clickable, start, end, flags)
        strBuilder.removeSpan(span)
    }




    private fun share(pesquisa: String, anos: String) {

        var experimentar = pesquisa.replace(" ","+")

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "http://contamehistorias.pt/arquivopt/search?query=" + experimentar + "&lastyears=" + anos + "&lang_code=pt")
        //shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title")
        startActivity(Intent.createChooser(shareIntent, "Share..."))

    }



}

