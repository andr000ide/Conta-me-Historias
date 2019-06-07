package com.example.projetofinal

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.modelclass.Media
import kotlinx.android.synthetic.main.media_item.view.*

class MediaAdapter(val mediaEle : ArrayList<Media>, val context: Context) : RecyclerView.Adapter<ViewHolderFour>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolderFour {
        val view = ViewHolderFour(LayoutInflater.from(context).inflate(R.layout.media_item, p0, false))

        return view
    }

    override fun getItemCount(): Int {
        return mediaEle.size
    }

    override fun onBindViewHolder(p0: ViewHolderFour, p1: Int) {
        p0.mediaTitulo.text = mediaEle.get(p1).titulo
        p0.mediaTexto.text = mediaEle.get(p1).texto
        p0.mediaOrganizacao.text = mediaEle.get(p1).organizacao
        p0.mediaLink.text = mediaEle.get(p1).link
    }
}

class ViewHolderFour (view: View) : RecyclerView.ViewHolder(view) {
    val mediaTitulo = view.titulo
    val mediaOrganizacao = view.organizacao
    val mediaTexto = view.texto
    val mediaLink = view.link
}