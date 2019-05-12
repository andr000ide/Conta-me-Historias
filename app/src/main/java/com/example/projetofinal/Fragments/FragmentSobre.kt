package com.example.projetofinal.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.EquipaAdapter
import com.example.projetofinal.modelclass.sobreTopico
import com.example.projetofinal.R
import kotlinx.android.synthetic.main.fragment_sobre.view.*


class FragmentSobre : androidx.fragment.app.Fragment(){

    val topicoArr : ArrayList<sobreTopico> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sobre, container, false)

        topicoArr.add(sobreTopico(titulo = "O que é o Conta-me Histórias? ", texto = "O Conta-me Histórias é um projeto científico, criado no âmbito dos Prémios Arquivo.pt 2018, que permite aos utilizadores a possibilidade de criarem automaticamente uma sumarização temporal das notícias preservadas pelo Arquivo.pt (http://arquivo.pt). Numa era marcada pela pós-verdade e pelas fake news, o Conta-me Histórias é um importante contributo para uma democracia mais transparente. Esta aplicação permite a qualquer cidadão um acesso livre e democrático a informação contextualizada, assente em fatos e tendencialmente livre de filtros, fazendo uso de diversas fontes. Jornalistas, estudantes e investigadores de diversas áreas, tais como a sociologia, a ciência política, as ciências da comunicaçãos, a história e outras humanidades, encontram aqui uma ferramenta poderosa para o seu trabalho.", url = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DrX1PjpyNHw\" frameborder=\"0\" allowfullscreen></iframe>"))
        topicoArr.add(sobreTopico(titulo = "Como funciona? ", texto = "O Arquivo.pt preserva milhões de ficheiros recolhidos da web desde 1996 e disponibiliza um serviço público de pesquisa sobre esta informação. Periodicamente recolhe e armazena informação publicada na Web. Este processo de preservação é realizado de forma automática através de um sistema informático distribuído de larga-escala.\n" +
                "\n" +
                "Para mostrar os dados do Arquivo.pt, mostramos ao utilizador os excertos mais importantes (nomeadamente títulos noticiosos) de um tópico ao longo do tempo. Para a seleção dos melhores títulos de notícias, recorremos a YAKE! um extrator de palavras-chave desenvolvido pela nossa equipa, e que recentemente foi premiado como Best Short Paper na 40ª edição da European Conference for Information Retrieval (ECIR'18 ).\n" +
                "\n" +
                "\n" +
                "Adicionalmente, utilizamos o SentiLex-PT01, uma ferramenta de análise de sentimentos para a língua portuguesa desenvolvida por uma equipa de investigadores nacional, utilizada no nosso projeto com o objetivo de analisar o sentimento dos títulos selecionados como relevantes pela YAKE!.\n" +
                "\n" +
                "\n" +
                "Finalmente, fazemos uso do PAMPO (desenvolvido por elementos da nossa equipa de investigação) com o objetivo de detetar o conjunto de termos relevantes mais relacionados com a pesquisa.", url = ""))
        topicoArr.add(sobreTopico(titulo = "Contribuições", texto = "Acreditamos que o Conta-me Histórias é, neste contexto, um importante contributo para uma democracia mais transparente, ao permitir a qualquer cidadão (incluindo jornalistas, estudantes, cientistas sociais de áreas como sociologia, ciência política, ciências da comunicação e história, etc) um acesso livre e democrático a informação contextualizada (assente em fatos e tendencialmente livre de filtros ao fazer uso de diversas fontes jornalísticas).", url = ""))
        topicoArr.add(sobreTopico(titulo = "Origem do nome", texto = "O nome 'Conta-me Histórias' é uma homenagem à música dos Xutos & Pontapés de mesmo nome, com o intuito de retratar um dos objetivos do projeto, ou seja, o de quereremos contar histórias ao utilizador, que, tal como diz a música, sejam relativas a algo que este não viu ou do qual não se recorda.", url =  "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/b4_ZBr2ijVw\" frameborder=\"0\" allowfullscreen></iframe>"))

        // Creates a vertical Layout Manager


        view.rec_view.setNestedScrollingEnabled(false)
        view.rec_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = EquipaAdapter(topicoArr, context!!)
        }


        view.rec_view.isNestedScrollingEnabled = false
        view.rec_view.isFocusable=false

        return view
    }
}