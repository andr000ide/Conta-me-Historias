package com.app.projetofinal.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.projetofinal.LangHelper
import com.app.projetofinal.MediaAdapter

import com.app.projetofinal.R
import com.app.projetofinal.modelclass.Media
import kotlinx.android.synthetic.main.fragment_media.view.*
import kotlinx.android.synthetic.main.fragment_media.view.rec_view


class Media : androidx.fragment.app.Fragment() {
    private lateinit var langHelper: LangHelper
    val mediaArr : ArrayList<Media> = ArrayList()
    val mediaArr2 : ArrayList<Media> = ArrayList()

    val mediaArrEn : ArrayList<Media> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_media, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        langHelper = LangHelper(activity!!.applicationContext)

        if(langHelper.getLanguageSaved().equals("en")){
            view.jornais.visibility = View.GONE
            mediaArr.add(Media(organizacao="FCCN", titulo = getString(R.string.media_en_titulo1), texto = "The main winner of the first edition of this prize was the “Conta-me Histórias” (Tell Me Stories) project, led by the researcher of INESC TEC, Ricardo Campos. The platform (https://www.contamehistorias.pt) offers a temporal narrative from the online news published on a particular topic.", link = "https://www.fccn.pt/en/premio-arquivo-pt-esta-de-volta-em-2019/", img = R.drawable.fccn))

            mediaArr.add(Media(organizacao="BIP Bulletin INESCTEC", titulo = getString(R.string.media_en_titulo2), texto = "Tell me Stories project developed by INESC TEC’s Laboratory of Artificial Intelligence and Decision Support (LIAAD) and winner of the Arquivo.pt Prize 2018, was presented by the researcher of LIAAD Ricardo Campos at the National Museum of Natural History and Science of the University of Lisbon", link = "http://bip.inesctec.pt/en/197/noticia-ev07.html", img = R.drawable.bip))
            mediaArr.add(Media(organizacao="BIP Bulletin INESCTEC", titulo = getString(R.string.media_en_titulo3), texto = "The new Portuguese news aggregation platform is called “Conta-me histórias” and received EUR 10 thousand for the first place under the Arquivo.pt Prizes 2018.", link = "http://bip.inesctec.pt/en/195/destaque.html", img = R.drawable.bip))
            mediaArr.add(Media(organizacao="INESCTEC", titulo = getString(R.string.media_en_titulo4), texto = "The new Portuguese news aggregation platform is called “Conta-me histórias” and received EUR 10 million for the first place under the Arquivo.pt Prizes 2018", link = "https://www.inesctec.pt/en/news/news-platform-with-inesc-tecs-know-how-rewarded-with-eur-10m?platform=hootsuite#intro", img = R.drawable.inesctec))

        }else{

            mediaArr.add(Media(organizacao="Antena 1", titulo =  getString(R.string.media_pt_titulo2),  texto = "Mais que um arquivo de sites e notícias em português, esta plataforma permite ao utilizador pesquisar por um certo tema e acompanhar a sua evolução ao longo do tempo.", link = "http://www.90segundosdeciencia.pt/episodes/ep-580-ricardo-campos/", img = R.drawable.antena1))

            mediaArr.add(Media(organizacao="TSF", titulo = getString(R.string.media_pt_titulo1), texto = "Uma nova plataforma agregadora de notícias portuguesas recebeu um prémio no valor de 10 mil euros.", link = "https://www.tsf.pt/sociedade/ciencia-e-tecnologia/interior/conta-me-historias-xutos-inspiram-projeto-premiado-9554297.html", img = R.drawable.tsf))

            mediaArr.add(Media("Rádio Comercial", getString(R.string.media_pt_titulo3),"","https://soundcloud.com/user-985956038/daniel-gomes-explica-como-participar-no-premio", img = R.drawable.radio_comercial))


            mediaArr2.add(Media("FCT", getString(R.string.media_pt_titulo4),"Primeira edição contou com 27 candidaturas. Os três prémios foram entregues pelo Comissário Europeu para a Investigação, Ciência e Inovação, Carlos Moedas. O projeto “Conta-me Histórias”, liderado por Ricardo Campos e cuja equipa conta com Arian Pasquali, Vítor Mangaravite, Alípio Jorge e Adam Jatowt, foi o grande vencedor desta primeira edição.","https://www.fccn.pt/conhecidos-os-vencedores-dos-premios-arquivo-pt", img = R.drawable.fct))
            mediaArr2.add(Media("Sapo.pt", getString(R.string.media_pt_titulo5),"A plataforma “Conta-me Histórias”, distinguida na terça-feira com um prémio de 10 mil euros, foi criada pelo Laboratório de Inteligência Artificial e Apoio à Decisão (LIAAD) do Instituto de Engenharia de Sistemas e Computadores, Tecnologia e Ciência (INESC TEC), do Porto, e pela Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com o assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", disse à Lusa Ricardo Campos, um dos responsáveis pelo projeto.","https://24.sapo.pt/tecnologia/artigos/conta-me-historias-uma-plataforma-onde-as-noticias-tem-memoria", img = R.drawable.sapo))
            mediaArr2.add(Media("Jornal Público", getString(R.string.media_pt_titulo6),"O projecto Conta-me Histórias foi o grande vencedor da primeira edição do prémio. “É um sumarizador temporal”, resume Ricardo Campos, investigador no Instituto de Engenharia de Sistemas e Computadores, Tecnologia e Ciência (Inesc-Tec, no Porto), docente no Instituto Politécnico de Tomar e um dos cinco autores desse projecto.","https://www.publico.pt/2019/01/24/ciencia/noticia/arquivopt-viagem-web-portuguesa-premeia-projectos-inovadores-1858823", img = R.drawable.publico))
            mediaArr2.add(Media("Jornal Cidade de Tomar / O Templário", getString(R.string.media_pt_titulo7),"A plataforma “Conta-me Histórias”, distinguida na terça-feira no Encontro Ciência 2018, foi desenvolvida por Ricardo Campos, docente do Instituto Politécnico de Tomar (IPT) e investigador do LIAAD INESC TEC, Arian Pasquali e Vitor Mangaravite, também investigadores\n" +
                    "\n" +
                    "do LIAAD INESC TEC, Alípio Jorge, coordenador do LIAAD do INESC TEC e docente na Faculdade de Ciências da Universidade do Porto, e Adam Jatowt docente da Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com um qualquer assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", refere Ricardo Campos.","http://www.pt.cision.com/cp2013/ClippingDetails.aspx?id=f9d421e3-0621-4918-ac05-5b732b964877&analises=1&cp=1", img = R.drawable.templario))
            mediaArr2.add(Media("IPT", getString(R.string.media_pt_titulo8),"A plataforma “Conta-me Histórias”, distinguida na terça-feira no Encontro Ciência 2018, foi desenvolvida por Ricardo Campos, docente do Instituto Politécnico de Tomar (IPT) e investigador do LIAAD INESC TEC, Arian Pasquali e Vitor Mangaravite, também investigadores do LIAAD INESC TEC, Alípio Jorge, coordenador do LIAAD do INESC TEC e docente na Faculdade de Ciências da Universidade do Porto, e Adam Jatowt docente da Universidade de Kyoto, permitindo ao utilizador \"familiarizar-se com um qualquer assunto\", através de notícias disponíveis no Arquivo.pt, \"sem necessidade de recorrer à leitura de todas as fontes\", refere Ricardo Campos.","http://portal2.ipt.pt/pt/noticias/cursos/docente_do_ipt_vencedor_da_1_edicao_dos_premios_arquivo_pt_2018_2018_07_04", img = R.drawable.ipt_tamanho))
            mediaArr2.add(Media("BIP Boletim INESC TEC", getString(R.string.media_pt_titulo9),"Chama-se “Conta-me Histórias” a nova plataforma portuguesa agregadora de notícias que foi premiada com 10 mil euros pela obtenção do primeiro lugar no âmbito dos prémios Arquivo.pt 2018. A entrega decorreu no dia 3 de julho, ao final da tarde, no Encontro Ciência 2018, na sessão plenária “Novas fronteiras da era digital na Europa e no Mundo”, que contou com a presença do Comissário para a Investigação, Ciência e Inovação da Comissão Europeia, Carlos Moedas.","http://bip.inesctec.pt/195/destaque.html", img = R.drawable.bip))
            mediaArr2.add(Media("BIP Boletim INESC TEC", getString(R.string.media_pt_titulo10),"O Conta-me Histórias, projeto desenvolvido pelo Laboratório de Inteligência Artificial e Apoio à Decisão (LIAAD) do INESC TEC e vencedor do Prémio Arquivo.pt 2018, foi apresentado pelo investigador do LIAAD Ricardo Campos no Museu Nacional de História Natural e da Ciência da Universidade de Lisboa.","http://bip.inesctec.pt/197/noticia-ev07.html", img = R.drawable.bip))
            mediaArr2.add(Media("FCT", getString(R.string.media_pt_titulo11),"O grande vencedor da primeira edição do prémio Arquivo.pt foi o projeto “Conta-me Histórias”, liderado pelo investigador do INESC TEC, Ricardo Campos.\n" +
                    "\n" +
                    "A plataforma [http://contamehistorias.pt] oferece uma narrativa temporal a partir das notícias publicadas online sobre um determinado tema.","https://www.fccn.pt/premio-arquivo-pt-esta-de-volta-em-2019/", img = R.drawable.fct))

            mediaArr2.add(Media("UP - FCUP - DCC", getString(R.string.media_pt_titulo12),"","https://www.dcc.fc.up.pt/site/noticias/ecir-2019", img = R.drawable.faculdade_ciencias_porto))

        }





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
