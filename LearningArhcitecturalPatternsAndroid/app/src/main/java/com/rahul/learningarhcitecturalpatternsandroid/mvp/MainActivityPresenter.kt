package com.rahul.learningarhcitecturalpatternsandroid.mvp

import android.util.Log
import com.rahul.learningarhcitecturalpatternsandroid.mvp.AndroidApp

public class MainActivityPresenter {

    public fun getData():AndroidApp{
        Log.d(this.javaClass.name, "getData() called from teh MainActivityPresenter Layer")
        return AndroidApp("ArchPatternsApp","1.0")
    }
}