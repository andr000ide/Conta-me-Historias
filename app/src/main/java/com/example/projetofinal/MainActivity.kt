package com.example.projetofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import android.util.Log
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import android.view.View
import androidx.core.view.GravityCompat
import com.example.projetofinal.Fragments.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.second_activitynew.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var langHelper: LangHelper
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101
    private var drawer: androidx.drawerlayout.widget.DrawerLayout? = null
    private var navView: NavigationView? = null

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


        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.title=""
        //actionbar?.title=getString(R.string.key_title)

        drawer = drawerlayout2
        val toggle = EndDrawerToggle(
            this, drawerlayout2, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerlayout2.addDrawerListener(toggle)
        toggle.syncState()

        navView = nav_view2
        navView?.setNavigationItemSelectedListener(this)

        val size = navView!!.menu.size()
        for (i in 0 until size) {
            navView!!.menu.getItem(i).isCheckable = false
            navView!!.menu.getItem(i).isChecked = false
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

    override fun onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // or finish();
        //super.onBackPressed()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

        when (p0.itemId) {
            R.id.nav_one -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","try")
                startActivity(randomIntent)
            }
            R.id.nav_two -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","pesquisar")
                startActivity(randomIntent)
            }
            R.id.nav_three -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","about")
                startActivity(randomIntent)
            }
            R.id.nav_four -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","team")
                startActivity(randomIntent)
            }
            R.id.nav_five -> {
                if(p0.title=="Português"){
                    refreshApp("pt")
                }
                else{
                    refreshApp("en")
                }
            }
            R.id.nav_six -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","agradecimentos")
                startActivity(randomIntent)
            }
            R.id.nav_eight  -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","contactos")
                startActivity(randomIntent)
            }
            R.id.nav_nine  -> {
                val randomIntent = Intent(this, SecondActivity::class.java)
                randomIntent.putExtra("indicacao","media")
                startActivity(randomIntent)
            }
        }

        drawer?.closeDrawer(GravityCompat.END)
        return true
    }
}


