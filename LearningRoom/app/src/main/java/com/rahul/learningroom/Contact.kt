package com.rahul.learningmvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long ,
    val text:String,
    val number:String,
)