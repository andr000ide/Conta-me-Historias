package com.example.projetofinal.modelclass

import com.squareup.moshi.Json

data class Example_Yake (
    @Json(name="keywords") var keywords: List<Keyword>,
    @Json(name="language") val language: String
)