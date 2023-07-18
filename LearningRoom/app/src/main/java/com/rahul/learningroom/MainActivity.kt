package com.rahul.learningroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.rahul.learningmvvm.Contact
import com.rahul.learningmvvm.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database:ContactDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java,"contactDB").build()


        GlobalScope.launch {
            database.contactDao().addContact(Contact(0,"Rahul","1231928398"))
//            database.contactDao().addContact(Contact(0,"Raj","1231928398"))
//            database.contactDao().addContact(Contact(0,"Ram","123192298"))
//            database.contactDao().addContact(Contact(0,"Ramesh","12319283238"))
        }

    }

    fun getContacts(view: View) {
        //   Log.d("MainActivity",database.contactDao().getAllContact().toString())
    }
}