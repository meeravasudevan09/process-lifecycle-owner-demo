package com.sivakame.processlifecycleapp

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner


class ProcessLifecycleApplication : Application(), LifecycleObserver {
    companion object {
        private const val TAG = "ProcessLifecycleApp"
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        Toast.makeText(this, "Goodbye!", Toast.LENGTH_LONG).show()
        Log.d(TAG, "App in background")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        Toast.makeText(this, "Welcome to the ProcessLifecycleApp", Toast.LENGTH_LONG).show()
        Log.d(TAG, "App in foreground")
    }
}