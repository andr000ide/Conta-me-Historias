package com.example.projetofinal.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.MediaAdapter

import com.example.projetofinal.R
import com.example.projetofinal.modelclass.Media
import com.example.projetofinal.modelclass.MembroEquipa
import kotlinx.android.synthetic.main.fragment_equipa_layout.view.*
import kotlinx.android.synthetic.main.fragment_media.view.*
import kotlinx.android.synthetic.main.fragment_media.view.rec_view
import kotlinx.android.synthetic.main.media_item.*


class Media : androidx.fragment.app.Fragment() {
    val mediaArr : ArrayList<Media> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_media, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mediaArr.add(Media(organizacao="Antena 133434", titulo = "Ep. 580 Ricardo Campos – “Conta-me histórias”, o arquivo de notícias que permite viajar pelo tempo", texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/"))
        mediaArr.add(Media(organizacao="Antena 2", titulo = "Ep. 580 Ricardo Campos – “Conta-me histórias”, o arquivo de notícias que permite viajar pelo tempo", texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/"))
        mediaArr.add(Media(organizacao="Antena 3", titulo = "Ep. 580 Ricardo Campos – “Conta-me histórias”, o arquivo de notícias que permite viajar pelo tempo", texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/"))
        mediaArr.add(Media(organizacao="Antena 4", titulo = "Ep. 580 Ricardo Campos – “Conta-me histórias”, o arquivo de notícias que permite viajar pelo tempo", texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/"))

        view.rec_view.setNestedScrollingEnabled(false)
        view.rec_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MediaAdapter(mediaArr, context!!)
        }
        /*view.linearlayout.isNestedScrollingEnabled=false


        view.rec_view.isNestedScrollingEnabled = false
        view.rec_view.isFocusable=false*/
    }
}
