package com.rahul.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
//import kotlinx.coroutines.DefaultExecutor.thread
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






    }
    suspend fun printHello(){
        print("Hello World from the world of couroutines")
    }

    fun updateCounter(view:View){
        var tvCounter = findViewById<TextView>(R.id.tvCounter)
        val tvCounterText = tvCounter.text.toString()
        var incrementedNumber = Integer.valueOf(tvCounterText)
        incrementedNumber = incrementedNumber + 1
        tvCounter.text = incrementedNumber.toString()

    }

    fun executeLongRunningTask2(view: View) {
        //This will start on the IO Thread
        CoroutineScope(Dispatchers.Main).launch{
            Log.d(TAG, "1-executeLongRunningTask() called on Thead ${Thread.currentThread().name}")
            executeTask1()
        }

        CoroutineScope(Dispatchers.Main).launch{
            Log.d(TAG, "1-executeLongRunningTask() called on Thead ${Thread.currentThread().name}")
            executeTask2()
        }
    }
    fun executeLongRunningTask(view: View) {
        //This will start on the IO Thread
        CoroutineScope(Dispatchers.IO).launch{
            Log.d(TAG, "1-executeLongRunningTask() called on Thead ${Thread.currentThread().name}")
            doLongRunningTask()

        }

        //Launches on the Global Scope of the Application
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "2-executeLongRunningTask() called on Thead ${Thread.currentThread().name}")

        }
        //Launches on the Activity Level Scope of the Application
        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "3-executeLongRunningTask() called on Thead ${Thread.currentThread().name}")

        }
    }



    //FIXME: this was using thread and the above one is using Coroutine
//    fun executeLongRunningTask(view: View) {
//        thread(start = true){
//            doLongRunningTask()
//        }
//
//    }


    suspend fun executeTask1(){
        Log.d(TAG, "executeTask1() called Task1 Started")
        //yield()//This is a suspension point
        delay(1000)//This is also a suspending function
        Log.d(TAG, "executeTask1() called Task1 Ended")
    }

    suspend fun executeTask2(){
        Log.d(TAG, "executeTask2() called Task2 Started")
        //yield()
        delay(2000)//This is also a suspending function
        Log.d(TAG, "executeTask2() called Task2 Ended")
    }

    private fun doLongRunningTask() {

//        for (i in 1..100000000000L){
//
//        }
    }
}