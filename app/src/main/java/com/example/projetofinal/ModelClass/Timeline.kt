package com.example.projetofinal

import com.squareup.moshi.Json

data class Timeline(
    @Json(name="data_interval_begin") val date_interval_begin : String,
    @Json(name="data_interval_end") val date_interval_end : String,
    @Json(name="headlines") val headlines : List<Headline>? = null
)