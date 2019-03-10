package com.example.projetofinal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import kotlinx.android.synthetic.main.pesquisar.view.*
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.pesquisar.*


class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.pesquisar, container, false)

        view.constraintclick.setOnFocusChangeListener { v, hasFocus -> view.constraintclick.hideKeyboard() }

        view.constraintclick.setOnClickListener {
           // view.constraintclick.hideKeyboard()
        }
        view.searchbar.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                println("iedije")
                val aux = view.spinner1.selectedItem
                println(aux)
                view.searchbar.hideKeyboard()
                view.constraintclick.requestFocus()
                //Perform Code
                return@OnKeyListener true
            }
            false
        })


        //get the spinner from the xml.
        val dropdown = view.spinner1
        //create a list of items for the spinner.
        //val items = arrayListOf<String>("5","10","15","20")
        val items = arrayOf("5", "10", "15","20")
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, items)
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter)
        dropdown.setSelection(1)




        view.advancedoptions.setOnClickListener {
            if(view.linear_visibility.visibility==View.INVISIBLE){
                view.advancedoptions.setTextColor(Color.GRAY)
                view.linear_visibility.visibility=View.VISIBLE
            }
            else{
                view.advancedoptions.setTextColor(Color.WHITE)
                view.linear_visibility.visibility=View.INVISIBLE
            }
        }



        return view
    }



    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }





}
