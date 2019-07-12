package com.app.projetofinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_rowview.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import android.text.Html


class AdapterNarrativas(val items : ArrayList<Headline>, val context: Context,val context2 : Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view =  ViewHolder(LayoutInflater.from(context).inflate(R.layout.frag_rowview,p0,false))

        return view
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var aux =  items.get(p1).keyphrase +"."
        p0.noticia?.text = aux
        p0.noticia.setOnClickListener {
            //items.get(p1).
            var site = items.get(p1).docs?.get(0)?.get(1)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(site))
            startActivity(context,intent,null)
        }
        //p0.data?.text = dateconverter(items.get(p1).date,context2)

        p0.data?.text = Html.fromHtml(dateconverter(items.get(p1).date,context2))


    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val noticia = view.noticia
    val data = view.data
}

fun dateconverter(date : String, context: Context) : String {
    var aux = date.split(" ")
    var aux2 = aux.get(0)
    var aux3 = aux2.split("-")

    var final= "<i>"

    final = final +aux3[2]+ " "

    var langHelper = LangHelper(context)

    if(langHelper.getLanguageSaved().equals("en")) {
        when(aux3.get(1)){
            "01"-> final = final + "of " +"January"
            "02"-> final = final + "of " +"February"
            "03"-> final = final + "of " +"March"
            "04"-> final = final + "of " +"April"
            "05"-> final = final + "of " +"May"
            "06"-> final = final + "of " +"June"
            "07"-> final = final + "of " +"July"
            "08"-> final = final + "of " +"August"
            "09"-> final = final + "of " +"September"
            "10"-> final = final + "of " +"October"
            "11"-> final = final + "of " +"November"
            "12"-> final = final + "of " +"December"
        }
    }
    else{
        when(aux3.get(1)){
            "01"-> final = final + "de " +"Janeiro"
            "02"-> final = final + "de " +"Fevereiro"
            "03"-> final = final + "de " +"Março"
            "04"-> final = final + "de " +"Abril"
            "05"-> final = final + "de " +"Maio"
            "06"-> final = final + "de " +"Junho"
            "07"-> final = final + "de " +"Julho"
            "08"-> final = final + "de " +"Agosto"
            "09"-> final = final + "de " +"Setembro"
            "10"-> final = final + "de " +"Outubro"
            "11"-> final = final + "de " +"Novembro"
            "12"-> final = final + "de " +"Dezembro"
        }
    }


    final = final + ", "+ aux3.get(0) +"</i>"

    return final
}