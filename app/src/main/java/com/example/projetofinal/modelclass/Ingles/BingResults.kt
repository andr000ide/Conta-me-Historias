package com.example.projetofinal.modelclass.Ingles

import com.squareup.moshi.Json

data class BingResults (
    @Json(name="from") val from: String,
    @Json(name="to") val to: String,
    @Json(name="n_docs") val nDocs: Int,
    @Json(name="keyphrases") val keyphrases: List<KeyPhrases>
)