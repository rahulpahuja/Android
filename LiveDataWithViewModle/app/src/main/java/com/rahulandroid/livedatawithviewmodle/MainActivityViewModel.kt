package com.rahulandroid.livedatawithviewmodle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel(){
    val factsDataO = MutableLiveData<String>("This is a fact")

    val factsData:LiveData<String>
        get()= factsDataO



    fun updateLiveData(){
        factsDataO.value = "New Live Data "+Math.random();
    }
}
