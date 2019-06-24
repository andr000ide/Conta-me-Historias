package com.example.projetofinal.Fragments


import android.graphics.drawable.Drawable
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
    val mediaArr2 : ArrayList<Media> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_media, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mediaArr.add(Media(organizacao="Antena 1", titulo = "\"Conta-me Histórias.\" Xutos inspiram projeto premiado", texto = "Uma nova plataforma agregadora de notícias portuguesas recebeu um prémio no valor de 10 mil euros.", link = "https://www.tsf.pt/sociedade/ciencia-e-tecnologia/interior/conta-me-historias-xutos-inspiram-projeto-premiado-9554297.html", img = R.drawable.antena1))

        mediaArr.add(Media(organizacao="TSF", titulo = "Ep. 580 Ricardo Campos – “Conta-me histórias”, o arquivo de notícias que permite viajar pelo tempo", texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/", img = R.drawable.tsf))
        mediaArr.add(Media("Rádio Comercial","Conta-me Histórias na Rádio Comercial by Daniel Gomes (Gestor Arquivo.pt)","","https://soundcloud.com/user-985956038/daniel-gomes-explica-como-participar-no-premio", img = R.drawable.radio_comercial))


        mediaArr2.add(Media("FCT","Conhecidos os Vencedores dos Prémios Arquivo.pt 2018","Primeira edição contou com 27 candidaturas. Os três prémios foram entregues pelo Comissário Europeu para a Investigação, Ciência e Inovação, Carlos Moedas. O projeto “Conta-me Histórias”, liderado por Ricardo Campos e cuja equipa conta com Arian Pasquali, Vítor Mangaravite, Alípio Jorge e Adam Jatowt, foi o grande vencedor desta primeira edição.","https://www.fccn.pt/conhecidos-os-vencedores-dos-premios-arquivo-pt", img = R.drawable.fct))
        mediaArr2.add(Media("Sapo.pt","Conta-me Histórias. Uma plataforma onde as notícias têm memória","A plataforma “Conta-me Histórias”, distinguida na terça-feira com um prémio de 10 mil euros, foi criada pelo Laboratório de Inteligência Artificial e Apoio à Decisão (LIAAD) do Instituto de Engenharia de Sistemas e Computadores, Tecnologia e Ciência (INESC TEC), do Porto, e pela Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com o assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", disse à Lusa Ricardo Campos, um dos responsáveis pelo projeto.","https://24.sapo.pt/tecnologia/artigos/conta-me-historias-uma-plataforma-onde-as-noticias-tem-memoria", img = R.drawable.sapo))
        mediaArr2.add(Media("Jornal Público","Arquivo.pt: uma viagem pela Web portuguesa que premeia projectos inovadores","O projecto Conta-me Histórias foi o grande vencedor da primeira edição do prémio. “É um sumarizador temporal”, resume Ricardo Campos, investigador no Instituto de Engenharia de Sistemas e Computadores, Tecnologia e Ciência (Inesc-Tec, no Porto), docente no Instituto Politécnico de Tomar e um dos cinco autores desse projecto.","https://www.publico.pt/2019/01/24/ciencia/noticia/arquivopt-viagem-web-portuguesa-premeia-projectos-inovadores-1858823", img = R.drawable.publico))
        mediaArr2.add(Media("Jornal Cidade de Tomar / O Templário","Docente do IPT é o responsável da equipa de investigação que venceu a primeira edição dos Prémios Arquivo.pt","A plataforma “Conta-me Histórias”, distinguida na terça-feira no Encontro Ciência 2018, foi desenvolvida por Ricardo Campos, docente do Instituto Politécnico de Tomar (IPT) e investigador do LIAAD INESC TEC, Arian Pasquali e Vitor Mangaravite, também investigadores\n" +
                "\n" +
                "do LIAAD INESC TEC, Alípio Jorge, coordenador do LIAAD do INESC TEC e docente na Faculdade de Ciências da Universidade do Porto, e Adam Jatowt docente da Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com um qualquer assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", refere Ricardo Campos.","http://www.pt.cision.com/cp2013/ClippingDetails.aspx?id=f9d421e3-0621-4918-ac05-5b732b964877&analises=1&cp=1", img = R.drawable.templario))
        mediaArr2.add(Media("IPT","Docente do IPT vencedor da 1.ª Edição dos Prémios Arquivo.pt 2018","A plataforma “Conta-me Histórias”, distinguida na terça-feira no Encontro Ciência 2018, foi desenvolvida por Ricardo Campos, docente do Instituto Politécnico de Tomar (IPT) e investigador do LIAAD INESC TEC, Arian Pasquali e Vitor Mangaravite, também investigadores do LIAAD INESC TEC, Alípio Jorge, coordenador do LIAAD do INESC TEC e docente na Faculdade de Ciências da Universidade do Porto, e Adam Jatowt docente da Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com um qualquer assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", refere Ricardo Campos.","http://portal2.ipt.pt/pt/noticias/cursos/docente_do_ipt_vencedor_da_1_edicao_dos_premios_arquivo_pt_2018_2018_07_04", img = R.drawable.ipt_tamanho))
        mediaArr2.add(Media("BIP Boletim INESC TEC","Plataforma de notícias premiada com 10 mil euros tem know-how português","Chama-se “Conta-me Histórias” a nova plataforma portuguesa agregadora de notícias que foi premiada com 10 mil euros pela obtenção do primeiro lugar no âmbito dos prémios Arquivo.pt 2018. A entrega decorreu no dia 3 de julho, ao final da tarde, no Encontro Ciência 2018, na sessão plenária “Novas fronteiras da era digital na Europa e no Mundo”, que contou com a presença do Comissário para a Investigação, Ciência e Inovação da Comissão Europeia, Carlos Moedas.","http://bip.inesctec.pt/195/destaque.html", img = R.drawable.bip))
        mediaArr2.add(Media("BIP Boletim INESC TEC","Conta-me Histórias e Unexmin na Noite Europeia dos Investigadores","O Conta-me Histórias, projeto desenvolvido pelo Laboratório de Inteligência Artificial e Apoio à Decisão (LIAAD) do INESC TEC e vencedor do Prémio Arquivo.pt 2018, foi apresentado pelo investigador do LIAAD Ricardo Campos no Museu Nacional de História Natural e da Ciência da Universidade de Lisboa.","http://bip.inesctec.pt/197/noticia-ev07.html", img = R.drawable.bip))
        mediaArr2.add(Media("FCT","Prémio Arquivo.pt está de volta em 2019!","O grande vencedor da primeira edição do prémio Arquivo.pt foi o projeto “Conta-me Histórias”, liderado pelo investigador do INESC TEC, Ricardo Campos.\n" +
                "\n" +
                "A plataforma [http://contamehistorias.pt] oferece uma narrativa temporal a partir das notícias publicadas online sobre um determinado tema.","https://www.fccn.pt/premio-arquivo-pt-esta-de-volta-em-2019/", img = R.drawable.fct))

        //mediaArr2.add(Media("","","",""))
        view.rec_view.setNestedScrollingEnabled(false)
        view.rec_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MediaAdapter(mediaArr, context!!)
        }

        view.rec_view2.setNestedScrollingEnabled(false)
        view.rec_view2.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MediaAdapter(mediaArr2, context!!)
        }
        /*view.linearlayout.isNestedScrollingEnabled=false


        view.rec_view.isNestedScrollingEnabled = false
        view.rec_view.isFocusable=false*/
    }
}
