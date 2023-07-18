package com.rahul.learningmvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    suspend fun addContact(contact:Contact)

    @Update
    suspend fun updateContact(contact:Contact)

    @Delete
    suspend fun deleteContact(contact:Contact)

//    @Query("SELECT * FROM contacts")
//    fun getAllContact():LiveData<List<Contact>>

}