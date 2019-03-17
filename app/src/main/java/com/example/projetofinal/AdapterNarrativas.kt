package com.example.projetofinal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_rowview.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.ContextCompat.startActivity






class AdapterNarrativas(val items : ArrayList<Headline>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view =  ViewHolder(LayoutInflater.from(context).inflate(R.layout.frag_rowview,p0,false))
        view.noticia.setOnClickListener {
            //items.get(p1).
            println("dedede")
            var site = items.get(p1).docs?.get(0)?.get(1)


            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(site))
            startActivity(context,intent,null)

        }

        println("kedeo")
        return view
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        println("dekodeokde")
        var aux =  "- "+items.get(p1).keyphrase +"."
        p0.noticia?.text = aux
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val noticia = view.noticia
}