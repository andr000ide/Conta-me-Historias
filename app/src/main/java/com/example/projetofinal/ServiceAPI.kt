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
    fun search_words(@Query("content")content : String, @Query("max_ngram_size") max_ngram_size : String ,@Query("number_of_keywords") number_of_keywords : String) : Call<Example>
}