package com.example.projetofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import android.util.Log
import androidx.core.app.ActivityCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var langHelper: LangHelper
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeReq()

        val checkIfFirstTime = intent.getBooleanExtra("FIRSTTIME", true)
        val checkIfFirstTime2 = intent.getBooleanExtra("SECONDTIME", false)
        langHelper = LangHelper(applicationContext)

        if (checkIfFirstTime == true) {
            refreshApp(langHelper.getLanguageSaved())
        }



        Btn_try.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)
            randomIntent.putExtra("indicacao","try")
            startActivity(randomIntent)
        }


        search_button.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)
            randomIntent.putExtra("indicacao","pesquisar")
            startActivity(randomIntent)
        }

    }


    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this@MainActivity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeReq()
        }
    }

    private fun makeReq(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                RECORD_REQUEST_CODE)
        } else {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), RECORD_REQUEST_CODE)
            } else {
                //saveFiles()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this@MainActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE)
    }



    fun refreshApp(lang: String) {
        val context = langHelper.setNewLocale(this, lang)
        val refresh = Intent(context, MainActivity::class.java)
        refresh.putExtra("FIRSTTIME", false)
        finish()
        startActivity(refresh)
    }
}


