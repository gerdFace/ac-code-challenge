package com.example.accodechallenge.screens.main

import androidx.lifecycle.*
import com.example.accodechallenge.api.ApiResult
import com.example.accodechallenge.api.ListFlyServiceWrapper
import com.example.accodechallenge.data.Contacts
import com.example.accodechallenge.util.exhaustive
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val listFlyServiceWrapper: ListFlyServiceWrapper) : ViewModel() {

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    private val hasError: MutableLiveData<Boolean> = MutableLiveData(false)
    private val contactsList: MutableLiveData<List<Contacts>> = MutableLiveData()

    fun watchIsLoading(): LiveData<Boolean> = isLoading
    fun watchHasError(): LiveData<Boolean> = hasError
    fun watchNameEmailList(): LiveData<List<String>> = Transformations.map(contactsList) { contactsList ->
        contactsList.mapNotNull { contacts ->
            if (contacts.firstName.isNotBlank() && contacts.lastName.isNotBlank()) {
                "${contacts.firstName} ${contacts.lastName}"
            } else if (contacts.email.isNotBlank()) {
                contacts.email
            } else {
                null
            }
        }
    }

    fun searchForContacts(name: String = "Test") {
        isLoading.value = true
        viewModelScope.launch {
            val result = listFlyServiceWrapper.getContactsByName(searchParameter = name)
            when (result) {
                is ApiResult.Success -> {
                    contactsList.value = result.data.contacts
                }
                is ApiResult.Error -> {
                    Timber.e(result.throwable)
                    hasError.value = true
                }
            }.exhaustive
            isLoading.value = false
        }
    }
}