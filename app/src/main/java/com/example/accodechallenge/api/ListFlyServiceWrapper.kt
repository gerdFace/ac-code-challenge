package com.example.accodechallenge.api

import com.example.accodechallenge.data.ContactsResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ListFlyServiceWrapper @Inject constructor(private val service: ListFlyService) : BaseService() {

    suspend fun getContactsByName(sortBy: SortBy = SortBy.DESC(), searchParameter: String = ""): Result<ContactsResponse> {
        return makeApiCall(
            dispatcher = Dispatchers.IO,
            call = { service.getContactsByName(sortBy = sortBy.asString, searchParameter = searchParameter) }
        )
    }
}