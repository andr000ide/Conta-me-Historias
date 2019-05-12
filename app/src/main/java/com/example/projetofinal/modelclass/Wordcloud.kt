package com.example.projetofinal.modelclass

import com.squareup.moshi.Json

data class Wordcloud(
    @Json(name="wordcloudb64") val wordcloudb64: String
)