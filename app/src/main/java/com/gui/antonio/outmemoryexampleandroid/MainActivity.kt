package com.gui.antonio.outmemoryexampleandroid

import android.app.ActivityManager
import android.content.ComponentCallbacks2
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityManagerCompat

class MainActivity : AppCompatActivity(), ComponentCallbacks2 {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mi = ActivityManager.MemoryInfo().also { s.getMemoryInfo(it) }
        Log.v("TAG", mi.totalMem.toString())
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        when (level) {
            ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN -> {
                Log.v("TAG", "The user interface has moved to the background.")
            }
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE,
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW,
            ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL -> {
                Log.v("TAG", "If the event is TRIM_MEMORY_RUNNING_CRITICAL, then the system will begin killing background processes.")
            }
            ComponentCallbacks2.TRIM_MEMORY_BACKGROUND,
            ComponentCallbacks2.TRIM_MEMORY_MODERATE,
            ComponentCallbacks2.TRIM_MEMORY_COMPLETE -> {
                Log.v("TAG", "If the event is TRIM_MEMORY_COMPLETE, the process will be one of the first to be terminated.")
            }
            else -> {
                Log.v("TAG", "The app received an unrecognized memory level value from the system. Treat this as a generic low-memory message.")
            }
        }
    }
}
