package com.app.projetofinal

import com.squareup.moshi.Json

data class TimeSpent(
    @Json(name="processing") val processing: Double,
    @Json(name="query") val query : Double,
    @Json(name="total") val total : Double
)