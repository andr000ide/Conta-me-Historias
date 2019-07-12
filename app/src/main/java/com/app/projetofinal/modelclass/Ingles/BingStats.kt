package com.app.projetofinal.modelclass.Ingles

import com.squareup.moshi.Json

data class BingStats (
    @Json(name="n_unique_docs") val nUniqueDocs: Int,
    @Json(name="n_docs") val nDocs: Int,
    @Json(name="n_domains") val nDomains: Int,
    @Json(name="time") val time: Double

)