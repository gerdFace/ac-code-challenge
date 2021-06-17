package com.example.accodechallenge.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Contacts(
    @Json(name = "cdate") val cDate: String?,
    val email: String,
    val phone: String,
    val firstName: String,
    val lastName: String,
    @Json(name = "orgid") val orgId: Int,
    @Json(name = "orgname") val orgName: String,
    @Json(name = "segmentio_id") val segmentioId: String,
    @Json(name = "bounced_hard") val bouncedHard: Int,
    @Json(name = "bounced_soft") val bouncedSoft: Int,
    @Json(name = "bounced_date") val bouncedDate: String?,
    val ip: Int,
    val ua: String?,
    val hash: String,
    @Json(name = "socialdata_lastcheck") val socialDataLastCheck: String?,
    @Json(name = "email_local") val emailLocal: String,
    val emailDomain: String,
    @Json(name = "sentcnt") val sentCnt: Int,
    @Json(name = "rating_tstamp") val ratingTstamp: String?,
    val gravatar: Int,
    val deleted: Int,
    val anonymized: Int,
    @Json(name = "adate") val aDate: String?,
    @Json(name = "udate") val uDate: String,
    @Json(name = "edate") val eDate: String?,
    @Json(name = "deleted_at") val deletedAt: String?,
    @Json(name = "created_utc_timestamp") val createdUtcTimestamp: String,
    @Json(name = "updated_utc_timestamp") val updatedUtcTimestamp: String,
    @Json(name = "created_timestamp") val createdTimestamp: String,
    @Json(name = "updated_timestamp") val updatedTimestamp: String,
    @Json(name = "created_by") val createdBy: String?,
    @Json(name = "updated_by") val updatedBy: String?,
    @Json(name = "email_empty") val emailEmpty: Boolean,
    val scoreValues: List<String>,
    val accountContacts: List<String>,
    val links: Links,
    val id: Int,
    val organization: String?
)