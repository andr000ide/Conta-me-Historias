package com.example.projetofinal.Fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.EquipaAdapter2
import com.example.projetofinal.modelclass.MembroEquipa
import com.example.projetofinal.R
import kotlinx.android.synthetic.main.fragment_sobre.view.*


class FragmentEquipa : androidx.fragment.app.Fragment() {

    val membrosArr : ArrayList<MembroEquipa> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_equipa_layout, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        membrosArr.add(MembroEquipa(nome = "Ricardo Campos", linkedin = "https://www.linkedin.com/in/camposricardo/", mail = "ricardo.campos@ipt.pt",  github = "",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.ricardo), cargo = getString(R.string.cargo_resea_prof)))
        membrosArr.add(MembroEquipa(nome = "Arian Pasquali", linkedin = "https://www.linkedin.com/in/arianpasquali/", mail = "arrp@inesctec.pt",   github = "https://github.com/arianpasquali",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.arian), cargo = getString(R.string.cargo_soft_resea)))
        membrosArr.add(MembroEquipa(nome = "Vitor Mangaravite", linkedin = "https://www.linkedin.com/in/v%C3%ADtor-mangaravite-81998222/", mail = "vima@inesctec.pt",   github = "https://github.com/vitordouzi",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.vitor), cargo = getString(R.string.cargo_soft_resea)))
        membrosArr.add(MembroEquipa(nome = "Alípio Jorge", linkedin = "https://www.linkedin.com/in/al%C3%ADpio-jorge-29085813/", mail = "amjorge@fc.up.pt",   github = "",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.alipio), cargo = getString(R.string.cargo_resea_prof)))
        membrosArr.add(MembroEquipa(nome = "Adam Jatowt", linkedin = "https://www.linkedin.com/in/adam-jatowt-a1869b4/", mail = "adam@dl.kuis.kyoti-u.ac.jp",   github = "",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.adam), cargo = getString(R.string.cargo_resea_prof)))
        membrosArr.add(MembroEquipa(nome = "Livia Stroschoen", linkedin = "https://www.linkedin.com/in/liviastroschoen/", mail = "liviapinent@gmail.com",   github = "",imagemUrl = BitmapFactory.decodeResource(this.resources,R.drawable.livia), cargo = getString(R.string.cargo_commuticaions)))

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

    }
}