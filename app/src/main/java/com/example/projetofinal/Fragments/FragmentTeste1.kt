package com.example.projetofinal.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.projetofinal.Headline
import com.example.projetofinal.R
import com.example.projetofinal.Timeline
import com.example.projetofinal.ViewPagerAdapterNarrativas
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.frag_searchview.view.*
import kotlinx.android.synthetic.main.frag_teste1.view.*
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import kotlinx.android.synthetic.main.second_activity.view.*
import java.io.Serializable
import java.sql.Time


class FragmentTeste1 : androidx.fragment.app.Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.frag_teste1, container, false)
        var jsonarray = arguments?.getString("timeline")

        var gson = Gson()
        val turnsType = object : TypeToken<List<Timeline>>() {}.type
        var testModel = gson.fromJson<List<Timeline>>(jsonarray, turnsType)

        val adapter = ViewPagerAdapterNarrativas(childFragmentManager)

        for(item in testModel){
            var jsonString = gson.toJson(item.headlines)
            var fragmento = FragmentVistaNarrativas.newInstance(jsonString,item.date_interval_end,item.date_interval_begin)
            adapter.addFragment(fragmento)
        }
        view.viewpagernarr.adapter = adapter

        view.viewpagernarr.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                var aux = view.viewpagernarr.currentItem
                var tam = view.viewpagernarr.adapter?.count

                if(aux==0){
                    view.seek_bar.setProgress(0,true)
                }else{
                    var colocar = 0
                    tam.let {
                        colocar= (aux*100/(tam!!-1))
                    }
                    view.seek_bar.setProgress(colocar,true)
                }
                println("fijf")
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                println("Iejide")
            }

            override fun onPageSelected(position: Int) {
                println("jeijide")
            }
        })

        return view

    }


    companion object {
        fun newInstance(timeline:String): FragmentTeste1 {
            val args = Bundle()
            args.putString("timeline",timeline)
            val fragment = FragmentTeste1()
            fragment.arguments = args
            return fragment
        }
    }

}
