package com.example.accodechallenge.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    val total: Int,
    val sortable: Boolean,
    @Json(name = "page_input") val pageInput: PageInput
)