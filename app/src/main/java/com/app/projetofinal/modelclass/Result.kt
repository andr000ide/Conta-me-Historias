package com.app.projetofinal


import com.squareup.moshi.Json

data class Result(
    @Json(name="domains") val domains : List<String>? = null,
    @Json(name="timeline") val timeline : List<Timeline>? = null
)