package com.example.projetofinal

import com.squareup.moshi.Json
import java.io.Serializable

data class Example (
    @Json(name="header") val header: Header,
    @Json(name="result") val result: Result
)