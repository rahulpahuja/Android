package com.rahul.learningcoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity5 : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private val TAG = "MainActivity5"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        lifecycleScope.launch {
            Log.d(TAG,"This from the MainActiity5 Scope")
            val intent = Intent(this@MainActivity5,MainActivity6::class.java)
            delay(2000)
            startActivity(intent)
            finish()
        }
    }
}