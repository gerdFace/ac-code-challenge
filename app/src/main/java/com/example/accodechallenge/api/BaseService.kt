package com.example.accodechallenge.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseService {

    // TODO: Add custom error handling
    // TODO: Handle pagination
    suspend fun <T> makeApiCall(dispatcher: CoroutineDispatcher, call: suspend () -> T): ApiResult<T> {
        return withContext(dispatcher) {
            try {
                ApiResult.Success(call.invoke())
            } catch (e: Exception) {
                ApiResult.Error(e)
            }
        }
    }
}