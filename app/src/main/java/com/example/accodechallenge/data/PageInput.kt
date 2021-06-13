package com.example.accodechallenge.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageInput(
    @Json(name = "segmentid") val segmentId: Int,
    @Json(name = "formid") val formId: Int,
    @Json(name = "listid") val listId: Int,
    @Json(name = "tagid") val tagId: Int,
    val limit: Int,
    val offset: Int,
    val search: String,
    val sort: String?,
    @Json(name = "seriesid") val seriesId: Int,
    @Json(name = "waitid") val waitId: Int,
    val status: Int,
    val forceQuery: Int,
    @Json(name = "cacheid") val cacheId: String
)
