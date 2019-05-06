package com.example.projetofinal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapterNarrativas(manager: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(manager) {

    private val fragmentList : MutableList<androidx.fragment.app.Fragment> = ArrayList()

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment (fragment : androidx.fragment.app.Fragment){
        fragmentList.add(fragment)
    }


}