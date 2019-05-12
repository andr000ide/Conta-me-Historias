package com.example.projetofinal.modelclass

import com.squareup.moshi.Json


data class Keyword (
    @Json(name="ngram") val ngram: String,
    @Json(name="score") val score: Double
)