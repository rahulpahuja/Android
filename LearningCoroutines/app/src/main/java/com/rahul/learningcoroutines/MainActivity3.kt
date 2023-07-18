package com.rahul.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity3 : AppCompatActivity() {
    private val TAG = "MainActivity3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }
    }

    private suspend fun executeOld() {
        //region Code Use Case 1
        //        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent execute: ${coroutineContext} ")
//
//            val childJob =  launch {
//                Log.d(TAG, "Child execute: ${coroutineContext} ")
//
//            }
////              Child Coroutines inherit the context of the parent coroutine by default
////            //Overriding Child coroutine context
////            val childJob =  launch(Dispatchers.IO) {
////                Log.d(TAG, "Child execute: ${coroutineContext} ")
////
////            }
//        }
        //endregion

        //region Code Use Case 2
//
//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent started ")
//
//            val childJob =  launch {
//                Log.d(TAG, "Child Started")
//                delay(5000)
//                Log.d(TAG, "Child Ended")
//
//            }
//            delay(3000)
//            Log.d(TAG, "Parent ended ")
//        }
//        parentJob.join()
//        Log.d(TAG,"Parent Completed")
//        //endregion
//
//        //region Code Use Case 3
//
//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent started ")
//
//            val childJob =  launch {
//                Log.d(TAG, "Child Started")
//                delay(5000)
//                Log.d(TAG, "Child Ended")
//
//            }
//            Log.d(TAG, "Parent ended ")
//        }
//        delay(1000)
//        parentJob.cancel()
//        parentJob.join()
//        Log.d(TAG,"Parent Completed")
        //endregion

        // region Code Use Case 4
//
//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent started ")
//
//            val childJob =  launch {
//                Log.d(TAG, "Child Started")
//                delay(5000)
//                Log.d(TAG, "Child Ended")
//
//            }
//            delay(3000)
//            Log.d(TAG,"Child Job Cancelled")
//            childJob.cancel()
//
//            Log.d(TAG, "Parent ended ")
//        }
////        delay(1000)
////        parentJob.cancel()
//        parentJob.join()
//        Log.d(TAG,"Parent Completed")
        //endregion


//        // region Code Use Case 5
//
//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent started ")
//
//            val childJob =  launch {
//                try {
//                    Log.d(TAG, "Child Started")
//                    delay(5000)
//                    Log.d(TAG, "Child Ended")
//                } catch (e: CancellationException) {
//                    Log.d(TAG,"Child Job Cancelled")
//                }
//
//            }
//            delay(3000)
//            childJob.cancel()
//
//            Log.d(TAG, "Parent ended ")
//        }
//
//        parentJob.join()
//        Log.d(TAG,"Parent Completed")
//        //endregion
    }

    private suspend fun execute(){
        val parentJob = CoroutineScope(Dispatchers.IO).launch {
            for( i in 1..1000){
                if(isActive){
                    Log.d(TAG, "execute() called $i")
                    executeLongRunningTask()
                }
            }
        }
        delay(100)
        Log.d(TAG,"Cancelling job")
        parentJob.cancel()
        parentJob.join()
        Log.d(TAG,"Cancelled job")
    }

    private fun executeLongRunningTask(){
        for( i in 1..100000000){

        }
    }

}