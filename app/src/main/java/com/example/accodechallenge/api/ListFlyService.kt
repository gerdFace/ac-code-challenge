package com.example.accodechallenge.api

import com.example.accodechallenge.data.ContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ListFlyService {

    @GET("contacts")
    suspend fun getContactsByName(
        @Query(value = "order[name]", encoded = true) sortBy: String,
        @Query(value = "limit") limit: Int = 50,
        @Query("search") searchParameter: String
    ): ContactsResponse
}