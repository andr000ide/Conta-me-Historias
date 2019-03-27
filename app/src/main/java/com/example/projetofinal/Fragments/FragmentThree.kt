package com.example.projetofinal.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.R
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import com.synnapps.carouselview.ViewListener
import kotlinx.android.synthetic.main.fragment_fragment_one.view.*


class FragmentThree : Fragment() {


    val numbers: IntArray = intArrayOf(com.example.projetofinal.R.drawable.en_en,
        com.example.projetofinal.R.drawable.en_en_dark, com.example.projetofinal.R.drawable.pt_pt,
        com.example.projetofinal.R.drawable.pt_pt_dark)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(com.example.projetofinal.R.layout.fragment_fragment_one, container, false)
        var carousel_View = view.carouselView
        carousel_View.pageCount = 5
        carousel_View.setViewListener(viewListener)

        return view
    }


    var viewListener: ViewListener = ViewListener {
        //set view attributes here
        layoutInflater.inflate(R.layout.custom_para_carrossel, null)
    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_one.text="Fragment Three"
    }

}
