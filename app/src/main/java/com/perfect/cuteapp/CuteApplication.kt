package com.perfect.cuteapp

import android.app.Application
import com.perfect.cuteapp.di.CuteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CuteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@CuteApplication)
            // declare modules
            modules(CuteModule.module)
        }
    }
}