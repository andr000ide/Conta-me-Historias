package com.example.projetofinal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)


        val service = RetrofitClientInstance.retrofitInstance?.create(ServiceAPI::class.java)
        val call = service?.custom_search("Brexit","10")
        call?.enqueue(object : Callback<Example> {


            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val examples = response.body()
                examples?.let {
                    println("ijferif")
                    //val refresh = Intent(this@SecondActivity, SecondActivity::class.java)
                    //startActivity(refresh)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(this@SecondActivity,"Erro no serviço ", Toast.LENGTH_SHORT)
            }
        })
    }
}