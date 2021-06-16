package com.example.accodechallenge.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.accodechallenge.api.ListFlyServiceWrapper
import com.example.accodechallenge.data.Contacts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val listFlyServiceWrapper: ListFlyServiceWrapper) : ViewModel() {

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    private val hasError: MutableLiveData<Boolean> = MutableLiveData(false)
    private val contactsList: MutableLiveData<List<Contacts>> = MutableLiveData(emptyList())

    fun watchIsLoading(): LiveData<Boolean> = isLoading
    fun watchHasError(): LiveData<Boolean> = hasError
    fun watchContactsList(): LiveData<List<Contacts>> = contactsList

    suspend fun delayThenError() {
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
            isLoading.postValue(false)
            hasError.postValue(true)
        }
    }
}