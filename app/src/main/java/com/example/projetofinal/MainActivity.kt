package com.example.projetofinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.util.Log
import android.support.v4.app.ActivityCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var langHelper: LangHelper
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()

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


    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this@MainActivity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this@MainActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE)
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


