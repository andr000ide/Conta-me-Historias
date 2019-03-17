package com.example.projetofinal.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projetofinal.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.second_activity.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentOne : Fragment(){
    private lateinit var helper: NarrativasHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.second_activity, container, false)
        val adapter = ViewPagerAdapter(childFragmentManager)

        helper= NarrativasHelper.instance

        val name1 = arguments?.getString("pesquisa")
        val name2 = arguments?.getString("anos")



        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search("Brexit", "10")
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                examples?.let {

                    var array = examples.result.timeline

                    var gson = Gson()
                    var jsonString = gson.toJson(array)


                    var fragmento1 = FragmentTeste1.newInstance(jsonString)
                    //var fragmento1 = FragmentTeste1.newInstance(array?.get(0)!!.headlines as ArrayList<Headline>,array?.get(0)!!.date_interval_end,array?.get(0)!!.date_interval_begin )
                    var fragmento2 = FragmentTeste2()

                    adapter.addFragment(fragmento1, "Narrativa")
                    adapter.addFragment(fragmento2, "Termos Relacionados")
                    view.viewpager.adapter = adapter
                    view.tabs.setupWithViewPager(view.viewpager)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(activity, "Erro no serviço ", Toast.LENGTH_SHORT)
            }
        })

        return view
    }


    companion object {
        fun newInstance(pesquisa: String, anos: String): FragmentOne {
            val args = Bundle()
            args.putString("pesquisa", pesquisa)
            args.putString("anos", anos)
            val fragment = FragmentOne()
            fragment.arguments = args
            return fragment
        }
    }

}
