package com.rahul.learningarhcitecturalpatternsandroid.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.rahul.learningarhcitecturalpatternsandroid.R
import com.rahul.learningarhcitecturalpatternsandroid.mvc.AndroidApp

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var clicker: TextView = findViewById<TextView>(R.id.clicker2)
        clicker.setOnClickListener({
            clicker.text= "This data came from the model layer ${MainActivityPresenter().getData().toString()}"
            Log.d(this.javaClass.name, "onCreate: ${MainActivityPresenter().getData().toString()}")
        })

    }
}