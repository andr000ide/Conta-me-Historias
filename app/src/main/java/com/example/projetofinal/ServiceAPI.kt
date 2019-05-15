package com.example.projetofinal

import com.example.projetofinal.modelclass.Algo
import com.example.projetofinal.modelclass.Example_Yake
import com.example.projetofinal.modelclass.Wordcloud
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.http.FormUrlEncoded



interface ServiceAPI {
    @GET("search?query=Brexit&last_years=10")
    fun something(): Call<Example>

    @GET("search?")
    fun custom_search(@Query(encoded = true, value="query")query : String, @Query(encoded = true, value="last_years") last_years : String) : Call<Example>

    @FormUrlEncoded
    @POST("extract_keywords?")
    fun search_words(@Field("content") content : String, @Query("max_ngram_size") max_ngram_size : String, @Query("number_of_keywords") number_of_keywords : String) : Call<Example_Yake>

    @GET("?")
    fun search_cloud(@Query("width") width : String,@Query("height") height : String,@Query("json") json : String) : Call<Wordcloud>

    @GET("bins/{algo2}")
    fun searchnovo(@Path("algo2")algo: String ) : Call<Example>

//    @POST("extract_keywords")
//    fun addAlgo(@Body newAlgo : String,@Query("max_ngram_size") max_ngram_size : String ,@Query("number_of_keywords" ) number_of_keywords : String) : Call<Example_Yake>

}