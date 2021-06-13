package com.example.accodechallenge.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    val bounceLogs: String,
    val contactAutomations: String,
    val contactData: String,
    val contactGoals: String,
    val contactLists: String,
    val contactLogs: String,
    val contactTags: String,
    val contactDeals: String,
    val deals: String,
    val fieldValues: String,
    val geoIps: String,
    val notes: String,
    val organization: String,
    val plusAppend: String,
    val trackingLogs: String,
    val scoreValues: String,
    val accountContacts: String,
    val automationEntryCounts: String
)