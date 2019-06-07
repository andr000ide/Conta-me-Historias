package com.example.projetofinal

import android.annotation.SuppressLint
import android.content.Context
import android.text.method.LinkMovementMethod
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

        p0.bind(mediaEle.get(p1))
        p0.mediaOrganizacao.setOnClickListener(){
            val expanded: Boolean = mediaEle.get(p1).isExpanded()
            if(expanded){
                mediaEle.get(p1).setExpanded(!expanded)
                notifyItemChanged(p1)
            }
            else{
                for((index, item) in mediaEle.withIndex()){
                    if(item.isExpanded()){
                        item.setExpanded(false)
                        notifyItemChanged(index)
                    }
                }
                mediaEle.get(p1).setExpanded(!expanded)
                notifyItemChanged(p1)
            }
            //sobreTopico.setExpanded(!expanded)
            //notifyItemChanged(p1)
        }
    }
}

class ViewHolderFour (view: View) : RecyclerView.ViewHolder(view) {
    val mediaTitulo = view.titulo
    val mediaOrganizacao = view.organizacao
    val mediaTexto = view.texto
    val mediaLink = view.link
    val sub_item = view.sub_item

    fun bind(mediaEl: Media) {
        val expanded = mediaEl.isExpanded()
        sub_item.setVisibility(if (expanded) View.VISIBLE else View.GONE)
    }
}