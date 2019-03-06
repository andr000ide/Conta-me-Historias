package com.example.projetofinal

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitClientInstance {
    private var retrofit: Retrofit? = null

    val retrofitInstance: Retrofit?
        get() {
            if(retrofit==null){
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl("http://contamehistorias.inesctec.pt/arquivopt/api/v1/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}