package com.app.projetofinal.modelclass.Ingles

import com.squareup.moshi.Json

data class BingResponse (
    @Json(name="domains") val domains: List<String>? = null,
    @Json(name="stats") val stats: BingStats,
    @Json(name="results") val results: List<BingResults>? = null
)