package com.example.projetofinal.Fragments



import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetofinal.AdapterNarrativas
import com.example.projetofinal.Headline
import com.example.projetofinal.R
import com.example.projetofinal.Timeline
import kotlinx.android.synthetic.main.frag_searchview.view.*
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import java.io.Serializable


class FragmentVistaNarrativas : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.frag_searchview, container, false)

        val inicio = arguments?.getString("begin")
        val fim = arguments?.getString("end")
        val listHeadline = arguments?.getSerializable("listHeadlines")
        val auxiliar = listHeadline as  ArrayList<Headline>
        var arrayNoticias = ArrayList<String>()
        /*
        for(item in auxiliar){
            arrayNoticias.add(item.keyphrase)
        }
        */

        view.recycler_view.setNestedScrollingEnabled(false)
        view.recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = AdapterNarrativas(auxiliar, context!!)
        }

       // view.recycler_view.adapter = AdapterNarrativas(arrayNoticias, context!!)

        view.titulo_narrativa.text= "- Noticias desde "+ inicio + " até " + fim +""

        return view

    }




    companion object {
        fun newInstance(headline: ArrayList<Headline>,end : String,begin : String): FragmentVistaNarrativas {
            val args = Bundle()
            args.putString("begin", begin)
            args.putString("end", end)
            args.putSerializable("listHeadlines",headline)
            val fragment = FragmentVistaNarrativas()
            fragment.arguments = args
            return fragment
        }
    }



}
