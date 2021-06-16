package com.example.accodechallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.accodechallenge.api.ListFlyServiceWrapper
import com.example.accodechallenge.api.Result
import com.example.accodechallenge.util.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var listFlyServiceWrapper: ListFlyServiceWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            val result = listFlyServiceWrapper.getContactsByName(searchParameter = "")
            when (result) {
                is Result.Success -> Timber.e(result.data.toString())
                is Result.Error -> Timber.e(result.throwable.toString())
            }.exhaustive
        }
    }
}