package com.rahulandroid.livedatawithviewmodle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel(){
    val factsData = MutableLiveData<String>("This is a fact")

    fun updateLiveData(){
        factsData.value = "New Live Data "+Math.random();
    }
}
