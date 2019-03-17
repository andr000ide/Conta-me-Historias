package com.example.projetofinal.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.Headline
import com.example.projetofinal.R
import com.example.projetofinal.Timeline
import com.example.projetofinal.ViewPagerAdapterNarrativas
import kotlinx.android.synthetic.main.frag_searchview.view.*
import kotlinx.android.synthetic.main.frag_teste1.view.*
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import kotlinx.android.synthetic.main.second_activity.view.*
import java.io.Serializable
import java.sql.Time


class FragmentTeste1 : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.frag_teste1, container, false)

        val array = arguments?.getSerializable("timeline") as ArrayList<Timeline>
        val adapter = ViewPagerAdapterNarrativas(childFragmentManager)

        println(array)
        println("jfdifd")


        for(item in array){
            var fragmento = FragmentVistaNarrativas.newInstance(item.headlines as ArrayList<Headline>,item.date_interval_end,item.date_interval_begin)
            adapter.addFragment(fragmento)
        }

        //var fragmento1 = FragmentVistaNarrativas.newInstance(array?.get(0)!!.headlines as ArrayList<Headline>,array?.get(0)!!.date_interval_end,array?.get(0)!!.date_interval_begin )
        //var fragmento2 = FragmentVistaNarrativas.newInstance(array?.get(1)!!.headlines as ArrayList<Headline>,array?.get(1)!!.date_interval_end,array?.get(1)!!.date_interval_begin )

        //adapter.addFragment(fragmento1)
        //adapter.addFragment(fragmento2)
        view.viewpagernarr.adapter = adapter


        return view

    }




    companion object {
        fun newInstance(timeline: ArrayList<Timeline>): FragmentTeste1 {
            val args = Bundle()
            args.putSerializable("timeline",timeline)
            val fragment = FragmentTeste1()
            fragment.arguments = args
            return fragment
        }
    }



}
