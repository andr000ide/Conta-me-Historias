package com.example.projetofinal.Fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.EquipaAdapter
import com.example.projetofinal.EquipaAdapter2
import com.example.projetofinal.ModelClass.MembroEquipa
import com.example.projetofinal.R
import kotlinx.android.synthetic.main.fragment_sobre.view.*


class FragmentEquipa : androidx.fragment.app.Fragment() {

    val membrosArr : ArrayList<MembroEquipa> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_equipa_layout, container, false)

        membrosArr.add(MembroEquipa(nome = "Ricardo Campos", linkedin = "https://www.linkedin.com/in/camposricardo/", mail = "ricardo.campos@ipt.pt", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.ricardo), cargo = "RESEARCHER AND PROFESSOR"))

        membrosArr.add(MembroEquipa(nome = "Arian Pasquali", linkedin = "https://www.linkedin.com/in/arianpasquali/", mail = "arrp@inesctec.pt", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.arian), cargo = "SOFTWARE DEVELOPER AND RESEARCHER"))
        membrosArr.add(MembroEquipa(nome = "Vitor Mangaravite", linkedin = "https://www.linkedin.com/in/v%C3%ADtor-mangaravite-81998222/", mail = "vima@inesctec.pt", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.vitor), cargo = "SOFTWARE DEVELOPER AND RESEARCHER"))


        membrosArr.add(MembroEquipa(nome = "Alípio Jorge", linkedin = "https://www.linkedin.com/in/al%C3%ADpio-jorge-29085813/", mail = "amjorge@fc.up.pt", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.alipio), cargo = "RESEARCHER AND PROFESSOR"))

        membrosArr.add(MembroEquipa(nome = "Adam Jatowt", linkedin = "https://www.linkedin.com/in/adam-jatowt-a1869b4/", mail = "adam@dl.kuis.kyoti-u.ac.jp", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.adam), cargo = "RESEARCHER AND PROFESSOR"))

        membrosArr.add(MembroEquipa(nome = "Livia Stroschoen", linkedin = "https://www.linkedin.com/in/liviastroschoen/", mail = "liviapinent@gmail.com", imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.livia), cargo = "COMMUNICATIONS"))



        view.rec_view.setNestedScrollingEnabled(false)
        view.rec_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = EquipaAdapter2(membrosArr, context!!)
        }


        view.rec_view.isNestedScrollingEnabled = false
        view.rec_view.isFocusable=false

        return view
    }
}