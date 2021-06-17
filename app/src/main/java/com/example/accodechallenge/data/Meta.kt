package com.example.accodechallenge.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    val total: Int? = 0,
    val sortable: Boolean = false,
    @Json(name = "page_input") val pageInput: PageInput?
)