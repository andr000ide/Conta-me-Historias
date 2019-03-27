package com.example.projetofinal.Fragments


import android.graphics.Color
import android.os.Bundle
import android.support.annotation.Dimension
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.wordcloud.ColorTemplate
import com.example.projetofinal.wordcloud.WordCloud
import kotlinx.android.synthetic.main.fragment_layout_wordcloud.view.*
import java.util.*


class FragmentTeste2 : Fragment() {



    val colors: IntArray = intArrayOf(
        Color.parseColor("#7f9650"),
        Color.parseColor("#d6812f"),
        Color.parseColor("#a66c54"),
        Color.parseColor("#d9534f"),
        Color.parseColor("#888888")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(com.example.projetofinal.R.layout.fragment_layout_wordcloud, container, false)

        var random = Random()
        val mutableList: ArrayList<WordCloud> = arrayListOf()
        mutableList.add(WordCloud("brexit", 5))
        mutableList.add(WordCloud("unido", 8))
        mutableList.add(WordCloud("reino", 2))
        mutableList.add(WordCloud("europeia", 4))
        mutableList.add(WordCloud("uniao", 2))
        mutableList.add(WordCloud("positive", 5))
        mutableList.add(WordCloud("bruxelas", 8))
        mutableList.add(WordCloud("acordo", 6))
        mutableList.add(WordCloud("cameron", 2))
        mutableList.add(WordCloud("negociacoes", 4))
        mutableList.add(WordCloud("londres", 5))
        mutableList.add(WordCloud("may", 2))
        mutableList.add(WordCloud("europeus", 1))
        mutableList.add(WordCloud("hotorrinalrdejei", 9))
        mutableList.add(WordCloud("negative", 8))
        mutableList.add(WordCloud("banco", 7))
        mutableList.add(WordCloud("britanico", 4))
        mutableList.add(WordCloud("saida", 7))
        mutableList.add(WordCloud("admite", 5))
        mutableList.add(WordCloud("juncker", 4))


        val wordCloud = view.wordCloud
        wordCloud.setScale(35, 20)
        wordCloud.setColors(colors)
        wordCloud.setDataSet(mutableList)
        wordCloud.notifyDataSetChanged()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}
