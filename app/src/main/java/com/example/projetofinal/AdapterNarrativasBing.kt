package com.example.projetofinal

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_rowview.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.projetofinal.modelclass.Ingles.KeyPhrases


class AdapterNarrativasBing(val items : ArrayList<KeyPhrases>, val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder2>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder2 {
        val view =  ViewHolder2(LayoutInflater.from(context).inflate(R.layout.frag_rowview,p0,false))

        return view
    }

    override fun onBindViewHolder(p0: ViewHolder2, p1: Int) {
        var aux =  "- "+items.get(p1).docs!!.get(0).get(0) +"."
        p0.noticia?.text = aux
        p0.noticia.setOnClickListener {
            //items.get(p1).
            var site = items.get(p1).docs!!.get(0).get(1)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(site))
            startActivity(context,intent,null)
        }


    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder2 (view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val noticia = view.noticia
}