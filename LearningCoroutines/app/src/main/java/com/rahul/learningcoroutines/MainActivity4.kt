package com.rahul.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity4 : AppCompatActivity() {
    private val TAG = "MainActivity4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        GlobalScope.launch {
            executeTask()
        }
    }

    private suspend fun executeTask() {
        //region Case 1
//        Log.d(TAG,"Before")
//        val job = GlobalScope.launch {
//         delay(1000)
//            Log.d(TAG,"Inside")
//        }
//        job.join()
//        Log.d(TAG,"After")
        //endregion
        //region Case 2
//        Log.d(TAG,"Before")
//        withContext(Dispatchers.IO) {
//         delay(1000)
//            Log.d(TAG,"Inside")
//        }
//        Log.d(TAG,"After")
        //endregion
        //region Case 3
//        runBlocking {
//            Log.d(TAG,"Before")
//            withContext(Dispatchers.IO) {
//                delay(1000)
//                Log.d(TAG,"Inside")
//            }
//            Log.d(TAG,"After")
//        }
        //endregion
    }
}