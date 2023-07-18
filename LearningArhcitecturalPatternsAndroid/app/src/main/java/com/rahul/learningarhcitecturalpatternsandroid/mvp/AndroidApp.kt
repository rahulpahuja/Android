package com.rahul.learningarhcitecturalpatternsandroid.mvp;

import android.util.Log

//Model layer for the MVC App
data class AndroidApp(var name:String, var version:String){
    init {
        Log.d(this.javaClass.name,"Hello from the Model layer ${this.name}")
    }

    override fun toString(): String {
        return "AndroidApp(name='$name', version='$version')"
    }


}