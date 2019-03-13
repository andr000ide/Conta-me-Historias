package com.example.projetofinal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.projetofinal.LangHelper
import com.example.projetofinal.R
import com.example.projetofinal.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var langHelper: LangHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkIfFirstTime = intent.getBooleanExtra("FIRSTTIME", true)
        langHelper = LangHelper(this)

        if (checkIfFirstTime == true) {
            refreshApp(langHelper.getLanguageSaved())
        }

        if (langHelper.getLanguageSaved() == "en") {
            portugal.setBackgroundResource(R.drawable.pt_pt_dark)
        } else {
            england.setBackgroundResource(R.drawable.en_en_dark)
        }


        portugal.setOnClickListener {
            if (langHelper.getLanguageSaved() != "pt") {
                refreshApp("pt")
            }

        }

        england.setOnClickListener {
            if (langHelper.getLanguageSaved() != "en") {
                refreshApp("en")
            }
        }
    }


    fun random(view: View) {
        val randomIntent = Intent(this, SecondActivity::class.java)
        startActivity(randomIntent)
    }

    fun refreshApp(lang: String) {
        val context = langHelper.setNewLocale(this, lang)
        val refresh = Intent(context, MainActivity::class.java)
        refresh.putExtra("FIRSTTIME", false)
        finish()
        startActivity(refresh)
    }
}


