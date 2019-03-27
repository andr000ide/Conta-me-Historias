package com.example.projetofinal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {
    @GET("search?query=Brexit&last_years=10")
    fun something(): Call<Example>

    @GET("search?")
    fun custom_search(@Query("query")query : String, @Query("last_years") last_years : String) : Call<Example>

    @GET("extract_keywords?")
    fun search_words()
}