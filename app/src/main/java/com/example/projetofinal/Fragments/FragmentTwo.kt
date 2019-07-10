package com.example.projetofinal.Fragments


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.text.SpannableStringBuilder
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.example.projetofinal.CustomDropDownAdapter
import com.example.projetofinal.R
import com.example.projetofinal.SecondActivity
import kotlinx.android.synthetic.main.pesquisar.view.*


class FragmentTwo : androidx.fragment.app.Fragment() {

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
                val aux = view.spinner1.selectedItem
                view.searchbar.hideKeyboard()
                view.constraintclick.requestFocus()


                //Perform Code
                return@OnKeyListener true
            }
            false
        })


        val listItemsTxt = arrayOf(getString(R.string.five_years), getString(R.string.ten_years), getString(R.string.fifteen_years), getString(
                    R.string.twenty_years))
        val spinnerAdapter = CustomDropDownAdapter(context!!, listItemsTxt)
        view.spinner1.adapter = spinnerAdapter
        //(view.spinner1.adapter as CustomDropDownAdapter).setSelection(1)
        view.spinner1.setSelection(1)


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

            val result = aux.trim()

            var aux3 = view.spinner1.selectedItemPosition
            //var aux2 = listItemsTxt.get(view.spinner1.selectedItemPosition)
            view.imagePesquisa.hideKeyboard()

            if(result.isNotEmpty()){
                val kotlinFragment = FragmentOne.newInstance(result,aux3)

                (activity as SecondActivity).replaceFragment(kotlinFragment)
            }
            else{
                buttonerrorempty(view)
            }


        }
        return view
    }


    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun buttonerrorempty(view: View) {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_mensagem_pesquisar_vazio)
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)

        val button = dialog.findViewById(R.id.buttonOk) as Button

        button.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}
