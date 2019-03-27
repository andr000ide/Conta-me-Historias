package com.example.projetofinal.Fragments


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.text.SpannableStringBuilder
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.projetofinal.CustomDropDownAdapter
import com.example.projetofinal.R
import com.example.projetofinal.SecondActivity
import kotlinx.android.synthetic.main.pesquisar.view.*


class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.pesquisar, container, false)

        view.constraintclick.setOnFocusChangeListener { _, _ ->
            run {
                view.constraintclick.hideKeyboard()
                view.imagePesquisa.setImageResource(R.drawable.ic_search_blue_24dp)
            }
        }


        view.constraintclick.setOnClickListener {
            // view.constraintclick.hideKeyboard()
        }

        view.searchbar.setOnFocusChangeListener { _, _ ->  view.imagePesquisa.setImageResource(R.drawable.ic_search_black_24dp) }


        view.searchbar.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
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


        val listItemsTxt = arrayOf("Last 5 years", "Last 10 years", "Last 15 years", "Last 20 years")
        val spinnerAdapter = CustomDropDownAdapter(context!!, listItemsTxt)
        view.spinner1.adapter = spinnerAdapter
        //(view.spinner1.adapter as CustomDropDownAdapter).setSelection(1)
        view.spinner1.setSelection(1)




        /*
        view.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //val selectedItem = parent.getItemAtPosition(position)
                //(view.spinner1.adapter as CustomDropDownAdapter).setSelection(position)
                println("j")
                //view.setBackgroundColor(Color.BLUE)
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        */


        /*
        //get the spinner from the xml.
        val dropdown = view.spinner1
        //create a list of items for the spinner.
        //val items = arrayListOf<String>("5","10","15","20")
        val items = arrayOf("5", "10", "15","20")
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        //val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, items)
    //set the spinners adapter to the previously created one.
        //dropdown.setAdapter(adapter)
        dropdown.setSelection(1)

    */


        view.advancedoptions.setOnClickListener {
            if (view.linear_visibility.visibility == View.INVISIBLE) {
                view.advancedoptions.setTextColor(Color.GRAY)
                view.linear_visibility.visibility = View.VISIBLE
            } else {
                view.advancedoptions.setTextColor(Color.WHITE)
                view.linear_visibility.visibility = View.INVISIBLE
            }
        }

        view.imagePesquisa.setOnClickListener {
            var aux = view.searchbar.text.toString()
            var aux3 = view.spinner1.selectedItemPosition
            //var aux2 = listItemsTxt.get(view.spinner1.selectedItemPosition)

            val kotlinFragment = FragmentOne.newInstance(aux,aux3)

            (activity as SecondActivity).replaceFragment(kotlinFragment)
        }
        return view
    }


    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


}
