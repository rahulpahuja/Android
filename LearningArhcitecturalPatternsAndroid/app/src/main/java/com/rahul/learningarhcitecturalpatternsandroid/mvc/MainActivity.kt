package com.rahul.learningarhcitecturalpatternsandroid.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.rahul.learningarhcitecturalpatternsandroid.R


//Video Ref: https://www.youtube.com/watch?v=97BRLkicQd0

//Why Patterns are needed Scalability , Maintainability

//This is controller layer for the mvc
class MainActivity : AppCompatActivity() {
    private val TAG:String = this.javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = AndroidApp("ArchPatternsApp","1.0")
        var clicker:TextView = findViewById<TextView>(R.id.clicker);
        clicker.setOnClickListener({
            clicker.text= "This data came from the model layer ${app.toString()}"
            Log.d(TAG, "onCreate: ${app.toString()}")
        })


    }
}