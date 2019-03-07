package com.example.projetofinal

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.second_activitynew.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{


    private var drawer : DrawerLayout? = null
    private var navView: NavigationView? = null
    private var check: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activitynew)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

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
            R.string.navigation_drawer_close)

        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        navView= nav_view
        navView?.setNavigationItemSelectedListener(this)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentOne())
                .addToBackStack("1").commit()
            navView?.setCheckedItem(R.id.nav_one)
            check = R.id.nav_one
        }

/*
        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search("Brexit","10")
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                examples?.let {
                    println("ijferif")
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
        when (p0.itemId){
            R.id.nav_one -> {
                if (check != R.id.nav_one) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentOne())
                        .addToBackStack("1").commit()
                    check = R.id.nav_one
                }
            }
            R.id.nav_two -> {
                if(check != R.id.nav_two){
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentTwo())
                        .addToBackStack("2").commit()
                    check = R.id.nav_two
                }
            }
            R.id.nav_three -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentThree())
                    .addToBackStack("3").commit()
                check = R.id.nav_three
            }
        }
        drawer?.closeDrawer(GravityCompat.END)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //var aux = supportFragmentManager.backStackEntryCount
        val aux = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount-1).name
        println("------------------ "+supportFragmentManager.backStackEntryCount)
        //navView?.setCheckedItem(R.id.nav_one)

        when (aux){
            "1" -> navView?.setCheckedItem(R.id.nav_one)
            "2" -> navView?.setCheckedItem(R.id.nav_two)
            "3" -> navView?.setCheckedItem(R.id.nav_three)
        }






        println("rfkofofr")
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)

        } else {

        }
    }
}