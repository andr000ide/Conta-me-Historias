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
import kotlinx.android.synthetic.main.frag_teste1.*
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
        var jsonarrayDomains = arguments?.getString("domains")

        var years = arguments?.getString("years")
        var query = arguments?.getString("query")

        var gson = Gson()
        val turnsType = object : TypeToken<List<Timeline>>() {}.type
        var testModel = gson.fromJson<List<Timeline>>(jsonarray, turnsType)



        val adapter = ViewPagerAdapterNarrativas(childFragmentManager)

        val emptyList = mutableListOf<String>()

        for(item in testModel){
            var jsonString = gson.toJson(item.headlines)
            var fragmento = FragmentVistaNarrativas.newInstance(jsonString,item.date_interval_end,item.date_interval_begin,
                query!!, jsonarrayDomains!!
            )
            emptyList.add(convertedata(item.date_interval_begin))
            adapter.addFragment(fragmento)
        }
        view.viewpagernarr.adapter = adapter
        val a = listOf<String>("03/17","23/18","05/19","06/19","06/19")
        view.step_view.setSteps(emptyList)
        view.step_view.selectedStep(0)

        view.viewpagernarr.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                var aux = view.viewpagernarr.currentItem
                var tam = view.viewpagernarr.adapter?.count



                if(aux==0){
                    step_view.selectedStep(0)
                }else{
                    step_view.selectedStep(aux+1)
                }
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })

        return view

    }

    fun convertedata(data: String):String{
        val strs = data.split("/").toTypedArray()

        val aux = strs.get(2)
        val aux2= aux.takeLast(2)
        return  strs.get(1)+"/"+aux2
    }

    companion object {
        fun newInstance(timeline:String, query : String , years : String , domains : String): FragmentTeste1 {
            val args = Bundle()
            args.putString("timeline",timeline)
            args.putString("query",query)
            args.putString("years",years)
            args.putString("domains",domains)
            val fragment = FragmentTeste1()
            fragment.arguments = args
            return fragment
        }
    }

}
