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
import com.example.projetofinal.AdapterNarrativas
import com.example.projetofinal.Headline
import com.example.projetofinal.R
import com.example.projetofinal.Timeline
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


class FragmentVistaNarrativas : androidx.fragment.app.Fragment() {

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


        //val aux = "<a href=\"http://www.google.com\">Google</a><a href=\"http://www.google.com\">Google</a>"
        //val aux = getString(R.string.helpere)
        val aux = "<a >This is cliclable text  5   </a>" +
                "<a href=\"http://www.xyz-zyyx.com\">This is cliclable text</a> "

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

        var text : String = "Portais de Notícias : "
        for (item in testMode2){
            text= text + " "+"http://"+item + " "
        }

        view.textview_domains.text=text


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
            adapter = AdapterNarrativas(testModel as ArrayList<Headline>, context!!)
        }

       // view.recycler_view.adapter = AdapterNarrativas(arrayNoticias, context!!)

        view.titulo_narrativa.text= query+" - Noticias desde "+ inicio + " até " + fim +""



        return view

    }

    companion object {
        fun newInstance(headline: String,end : String,begin : String,query :String, domains : String): FragmentVistaNarrativas {
            val args = Bundle()
            args.putString("begin", begin)
            args.putString("end", end)
            args.putString("headline",headline)
            args.putString("query",query)
            args.putString("domains",domains)
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



}
