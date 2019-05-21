package com.example.projetofinal

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import com.example.projetofinal.Fragments.*
import kotlinx.android.synthetic.main.second_activitynew.*


class SecondActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawer: androidx.drawerlayout.widget.DrawerLayout? = null
    private var navView: NavigationView? = null
    private var check: Int = 0
    private lateinit var langHelper: LangHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activitynew)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val indicator:String = intent.getStringExtra("indicacao")

        langHelper = LangHelper(applicationContext)
        /*
         val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(),"One")
        adapter.addFragment(FragmentOne(),"two")
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)
        */

        drawer = drawerlayout
        val toggle = EndDrawerToggle(
            this, drawerlayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        navView = nav_view
        navView?.setNavigationItemSelectedListener(this)


        if (savedInstanceState == null) {
            if(indicator.equals("try")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentThree()
                )
                    .addToBackStack("3").commit()
                navView?.setCheckedItem(R.id.nav_one)
                check = R.id.nav_one
            }
            else{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentTwo()
                )
                    .addToBackStack("2").commit()
                navView?.setCheckedItem(R.id.nav_two)
                check = R.id.nav_two
            }

        }

/*
        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search("Brexit","10")
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                examples?.let {
                    val refresh = Intent(this@SecondActivity, SecondActivity::class.java)
                    //refresh.putExtra("EXTRA_PEOPLE", examples)
                    startActivity(refresh)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(this@SecondActivity,"Erro no serviço ", Toast.LENGTH_SHORT)
            }
        })
        */
    }



    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_one -> {
                if (check != R.id.nav_one) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                        FragmentThree()
                    )
                        .addToBackStack("1").commit()
                    check = R.id.nav_one
                }
            }
            R.id.nav_two -> {
                if (check != R.id.nav_two) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                        FragmentTwo()
                    )
                        .addToBackStack("2").commit()
                    check = R.id.nav_two
                }
            }
            R.id.nav_three -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentSobre()
                )
                    .addToBackStack("3").commit()
                check = R.id.nav_three
            }
            R.id.nav_four -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentEquipa()
                )
                    .addToBackStack("4").commit()
                check = R.id.nav_four
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
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentAgradecimentos()
                )
                    .addToBackStack("6").commit()
                check = R.id.nav_six
            }
            R.id.nav_seven  -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    fragment_credits()
                )
                    .addToBackStack("7").commit()
                check = R.id.nav_seven
            }
        }

        drawer?.closeDrawer(GravityCompat.END)
        return true
    }


    fun emptybackstack(){
        val fm = getSupportFragmentManager()
        for (i in 0 until fm.getBackStackEntryCount()) {
            fm.popBackStack()
        }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).addToBackStack("").commit()
    }


    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount ==1){
            supportFragmentManager.popBackStack()
        }
        super.onBackPressed()
        //var aux = supportFragmentManager.backStackEntryCount
        if(supportFragmentManager.backStackEntryCount >0){


        val aux = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        println("------------------ " + supportFragmentManager.backStackEntryCount)
        //navView?.setCheckedItem(R.id.nav_one)

        when (aux) {
            "1" -> {
                navView?.setCheckedItem(R.id.nav_one)
                check=R.id.nav_one
            }
            "2" -> {
                navView?.setCheckedItem(R.id.nav_two)
                check=R.id.nav_two
            }
            "3" -> {
                navView?.setCheckedItem(R.id.nav_three)
                check=R.id.nav_three
            }
        }


        }
        else{

        }

        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)

        } else {

        }
    }


    fun refreshApp(lang: String) {
        val context = langHelper.setNewLocale(this, lang)
        val refresh = Intent(context, MainActivity::class.java)
        refresh.putExtra("SECONDTIME", false)
        finish()
        startActivity(refresh)
    }




}