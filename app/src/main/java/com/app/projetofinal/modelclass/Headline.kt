package com.app.projetofinal

import com.squareup.moshi.Json

data class Headline(
    @Json(name="date") val date :String,
    @Json(name="docs") val docs : List<List<String>>? = null,
    @Json(name="keyphrase") val keyphrase : String
)