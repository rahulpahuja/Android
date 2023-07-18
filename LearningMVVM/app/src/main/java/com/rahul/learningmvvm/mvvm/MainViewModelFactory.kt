package com.rahul.learningmvvm.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val quoteRepo:QuotesRepository) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepo) as T
    }

}
