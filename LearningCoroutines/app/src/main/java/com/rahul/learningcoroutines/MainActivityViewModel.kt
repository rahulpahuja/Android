package com.rahul.learningcoroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val TAG: String? = "MainActivityViewModel"

    init{
        viewModelScope.launch {
            while (true){
                delay(500)
                Log.d(TAG,"Hello")
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")

    }
}