package com.example.accodechallenge.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContactsResponse(
    val scoreValues: List<String> = emptyList(),
    val contacts: List<Contacts>,
    val meta: Meta?
)