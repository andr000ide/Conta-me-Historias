package com.example.projetofinal


import com.squareup.moshi.Json

data class Stats(
    @Json(name="domains") val domains : Int,
    @Json(name="hits") val hits : Int,
    @Json(name="news") val news : Int,
    @Json(name="time_spent") val time_spent : TimeSpent
)