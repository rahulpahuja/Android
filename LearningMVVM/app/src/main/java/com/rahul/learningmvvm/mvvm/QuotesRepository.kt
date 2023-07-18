package com.rahul.learningmvvm.mvvm

import androidx.lifecycle.LiveData

class QuotesRepository(val dao:QuoteDao) {

    fun getQuotes():LiveData<List<Quote>>{
        return  dao.getQuotes()
    }

    suspend fun addQuote(quote: Quote){
        return  dao.addQuote(quote)
    }

    suspend fun deleteQuote(quote: Quote){
        return  dao.deleteQuote(quote)
    }
    suspend fun updateQuote(quote: Quote){
        return  dao.updateQuote(quote)
    }

}