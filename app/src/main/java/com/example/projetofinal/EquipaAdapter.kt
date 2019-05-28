package com.example.projetofinal

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.modelclass.sobreTopico
import kotlinx.android.synthetic.main.sobre_layout.view.*


class EquipaAdapter(val topicos : ArrayList<sobreTopico>, val context: Context) : RecyclerView.Adapter<ViewHoldertwo>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHoldertwo {
        val view = ViewHoldertwo(LayoutInflater.from(context).inflate(R.layout.sobre_layout, p0, false))

        //view.topicoTexto.visibility = View.INVISIBLE

        return view
    }

    override fun getItemCount(): Int {
        return topicos.size
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onBindViewHolder(p0: ViewHoldertwo, p1: Int) {

        val sobreTopico: sobreTopico = topicos[p1]
        p0.topicoTitulo?.text = topicos.get(p1).titulo
        p0.topicoTexto.text = topicos.get(p1).texto
        //p0.topicoTexto.justificationMode= Layout.JUSTIFICATION_MODE_INTER_WORD

        // val uri = Uri.parse(sobreTopico.url)
        //p0?.video_view.setVideoURI(uri)
        p0.video_view.settings.javaScriptEnabled = true
        //holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );
        //p0?.video_view.loadUrl(sobreTopico.url)
        if (sobreTopico.url != ""){
            p0.video_view.visibility = View.VISIBLE
            p0.video_view.loadData(sobreTopico.url, "text/html","utf-8")
        }else {
            p0.video_view.visibility = View.GONE
        }

        p0.bind(sobreTopico)
        p0.topicoTitulo.setOnClickListener(){
            val expanded: Boolean = sobreTopico.isExpanded()
            if(expanded){
                sobreTopico.setExpanded(!expanded)
                notifyItemChanged(p1)
            }
            else{
                for((index, item) in topicos.withIndex()){
                    if(item.isExpanded()){
                        item.setExpanded(false)
                        notifyItemChanged(index)
                    }
                }
                sobreTopico.setExpanded(!expanded)
                notifyItemChanged(p1)
            }
            //sobreTopico.setExpanded(!expanded)
            //notifyItemChanged(p1)
        }
    }
}

class ViewHoldertwo (view: View) : RecyclerView.ViewHolder(view) {

    val topicoTitulo = view.topico_titulo
    val topicoTexto = view.topico_texto
    val sub_item = view.sub_item
    val video_view = view.video_view
    fun bind(sobreTopico: sobreTopico) {
        val expanded = sobreTopico.isExpanded()

        sub_item.setVisibility(if (expanded) View.VISIBLE else View.GONE)

    }

 }