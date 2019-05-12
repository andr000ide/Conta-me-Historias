package com.example.projetofinal.modelclass

import com.squareup.moshi.Json

data class Example_Yake (
    @Json(name="keywords") val keywords: List<Keyword>,
    @Json(name="language") val language: String
)