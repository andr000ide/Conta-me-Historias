package com.app.projetofinal

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MenuItem
import com.app.projetofinal.Fragments.*
import kotlinx.android.synthetic.main.second_activitynew.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory


class SecondActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawer: androidx.drawerlayout.widget.DrawerLayout? = null
    private var navView: NavigationView? = null
    private lateinit var imagem : Bitmap
    private var check: Int = 0
    private lateinit var langHelper: LangHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activitynew)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.title=getString(R.string.key_title)
        actionbar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_home_black_24dp)

        val indicator:String = intent.getStringExtra("indicacao")

        langHelper = LangHelper(applicationContext)
        /*
         val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(),"One")
        adapter.addFragment(FragmentOne(),"two")
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)
        */
        imagem= BitmapFactory.decodeResource(applicationContext.resources,R.drawable.fcup)

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
                    .addToBackStack("1").commit()
                navView?.setCheckedItem(R.id.nav_one)
                check = R.id.nav_one
            }
            else if(indicator.equals("pesquisar")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentTwo()
                )
                    .addToBackStack("2").commit()
                navView?.setCheckedItem(R.id.nav_two)
                check = R.id.nav_two
            }
            else if(indicator.equals("about")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentSobre()
                )
                    .addToBackStack("3").commit()
                navView?.setCheckedItem(R.id.nav_three)
                check = R.id.nav_three
            }
            else if(indicator.equals("team")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentEquipa()
                )
                    .addToBackStack("4").commit()
                navView?.setCheckedItem(R.id.nav_four)
                check = R.id.nav_four
            }
            else if(indicator.equals("agradecimentos")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentAgradecimentos()
                )
                    .addToBackStack("6").commit()
                navView?.setCheckedItem(R.id.nav_six)
                check = R.id.nav_six
            }
            else if(indicator.equals("contactos")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    fragment_contacts()
                )
                    .addToBackStack("8").commit()
                navView?.setCheckedItem(R.id.nav_eight)
                check = R.id.nav_eight
            }
            else if(indicator.equals("media")){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    Media()
                )
                    .addToBackStack("9").commit()
                navView?.setCheckedItem(R.id.nav_nine)
                check = R.id.nav_nine
            }
            else{

            }

        }
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
            R.id.nav_eight  -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    fragment_contacts()
                )
                    .addToBackStack("8").commit()
                check = R.id.nav_eight
            }
            R.id.nav_nine  -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    Media()
                )
                    .addToBackStack("9").commit()
                check = R.id.nav_nine
            }
            else ->{
                return false
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
            //navView?.setCheckedItem(R.id.nav_null)
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
            "4" -> {
                navView?.setCheckedItem(R.id.nav_four)
                check=R.id.nav_four
            }
            "6" -> {
                navView?.setCheckedItem(R.id.nav_six)
                check=R.id.nav_six
            }
            "8" -> {
                navView?.setCheckedItem(R.id.nav_eight)
                check=R.id.nav_eight
            }
            "9" -> {
                navView?.setCheckedItem(R.id.nav_nine)
                check=R.id.nav_nine
            }
            else -> {
                navView?.setCheckedItem(R.id.nav_nine)
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
        refresh.putExtra("FIRSTTIME", false)
        finish()
        startActivity(refresh)

    }

    fun setImagem(imag : Bitmap){
        imagem=imag
    }

    fun getImagem():Bitmap {
        return imagem
    }




}