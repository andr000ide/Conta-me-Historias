package com.example.projetofinal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.second_activity.view.*


class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.second_activity, container, false)
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(FragmentTeste1(),"One")
        adapter.addFragment(FragmentTeste2(),"two")
        view.viewpager.adapter = adapter
        view.tabs.setupWithViewPager(view.viewpager)

        return view

    }


}
