package com.rahul.learningmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {

    @Query("Select * From quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun addQuote(quote: Quote)


    @Update
    suspend fun updateQuote(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote: Quote)


}