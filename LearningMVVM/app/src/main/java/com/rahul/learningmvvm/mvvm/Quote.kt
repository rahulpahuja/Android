package com.rahul.learningmvvm.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id :Long,
    val text:String,
    val author:String
)