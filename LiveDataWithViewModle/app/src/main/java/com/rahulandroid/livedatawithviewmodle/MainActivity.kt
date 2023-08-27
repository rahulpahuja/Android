package com.rahulandroid.livedatawithviewmodle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel:MainActivityViewModel

    val button : Button
    get()=findViewById(R.id.btnUpdateTextValue)
    val txt : TextView
    get()=findViewById(R.id.textValue)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.factsData.observe(this,{
            txt.text = mainActivityViewModel.factsData.value.toString()
        })

        button.setOnClickListener(){
            mainActivityViewModel.updateLiveData()
        }
    }
}