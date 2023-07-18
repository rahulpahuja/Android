package com.rahul.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    private val TAG: String? = "MainActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }


//        val job = CoroutineScope(Dispatchers.IO).launch {
//            printFollowers()
//        }

//        job.cancel()//Cancel Coroutine
//        job.join()//Suspends our coroutines and joins it to other one


    }


    //NORMAL COROUTINE
//    private suspend fun printFollowers() {
//        var fbFollowers =0
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//        }
//        job.join()
//        Log.d(TAG, "printFollowers: ${fbFollowers}")
//    }


//    //ASYNC COROUTINES
//    private suspend fun printFollowers() {
//        val job = CoroutineScope(Dispatchers.IO).async {
//            //This will return a Deffered of T where T is the data type
//            //returned by the last statement in this block in this case it is
//            //Deffered<Int>
//
//            //launch method Retruns a Job Object , async method returns a deffered object
//             getFbFollowers()
//        }
//        Log.d(TAG, "printFollowers: ${job.await().toString()}")
//    }

//    //NORMAL COROUTINE
//    private suspend fun printFollowers() {
//        var fbFollowers =0
//        var instaFollowers =0
//        val job1 = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//            instaFollowers = getInstaFollowers()
//        }
//        val job2 = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//            instaFollowers = getInstaFollowers()
//        }
//        job1.join()
//        job2.join()
//        Log.d(TAG, "printFollowers: ${fbFollowers}")
//        Log.d(TAG, "printFollowers: ${instaFollowers}")
//    }


//    private suspend fun printFollowers() {
//        var fbFollowers = 0 ;var instaFollowers =0
//        val job1 = CoroutineScope(Dispatchers.IO).async {
//             getFbFollowers()
//        }
//        val job2 = CoroutineScope(Dispatchers.IO).async {
//             getInstaFollowers()
//        }
//        Log.d(TAG, "printFollowers: ${job1.await().toString()}")
//        Log.d(TAG, "printFollowers: ${job2.await().toString()}")
//    }

    private suspend fun printFollowers() {
        CoroutineScope(Dispatchers.IO).launch {
             var fbFollowers = async{getFbFollowers()}
             var instaFollowers = async {  getInstaFollowers() }
            Log.d(TAG, "printFollowers: ${fbFollowers.await()}")
            Log.d(TAG, "printFollowers: ${instaFollowers.await()}")
        }


    }




    private suspend fun getFbFollowers() :Int {
        delay(1000)
        return 54

    }
    private suspend fun getInstaFollowers() :Int {
        delay(1000)
        return 51129

    }

    fun executeLongRunningTask2(){

    }
    fun updateCounter(){

    }
}