package com.example.accodechallenge.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseService {

    // TODO: Add custom error handling
    suspend fun <T> makeApiCall(dispatcher: CoroutineDispatcher, call: suspend () -> T): Result<T> {
        return withContext(dispatcher) {
            try {
                Result.Success(call.invoke())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}