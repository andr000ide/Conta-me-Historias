package com.app.projetofinal.modelclass.Ingles

import com.squareup.moshi.Json

data class KeyPhrases (
    @Json(name="kw") val kw: String,
    @Json(name="date") val date: String,
    @Json(name="docs") val docs: List<List<String>>? = null
)