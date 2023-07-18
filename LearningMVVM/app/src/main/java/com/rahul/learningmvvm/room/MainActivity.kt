package com.rahul.learningmvvm.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahul.learningmvvm.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database:ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB.db").build()


        GlobalScope.launch {
            database.contactDao().addContact(Contact(0,"Rahul","1231928398"))
            database.contactDao().addContact(Contact(0,"Raj","1231928398"))
            database.contactDao().addContact(Contact(0,"Ram","123192298"))
            database.contactDao().addContact(Contact(0,"Ramesh","12319283238"))
        }



    }

    fun getContacts(view: View) {
        val allContact = database.contactDao().getAllContact().observe(this,{
                Log.d("Hi", it.toString()+"/n")
        })

    }
}