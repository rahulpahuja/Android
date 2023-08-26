package com.rahulandroid.lifecycleawarecomponents

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class FragmentObserver(name:String) : LifecycleObserver {


        private var TAG = "My App Fragment Observer"

        init {
            TAG = name
        }


        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            Log.d(TAG, "onCreate() called ")
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            Log.d(TAG, "onStart() called")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume() {
            Log.d(TAG, "onResume() called")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPause() {
            Log.d(TAG, "onPause() called")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop() {
            Log.d(TAG, "onStop() called")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            Log.d(TAG, "onDestroy() called")
        }


}
