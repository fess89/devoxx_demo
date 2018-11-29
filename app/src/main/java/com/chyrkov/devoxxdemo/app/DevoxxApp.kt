package com.chyrkov.devoxxdemo.app

import android.app.Application
import com.chyrkov.devoxxdemo.di.KoinModules
import org.koin.android.ext.android.startKoin

class DevoxxApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, KoinModules().getModules())
    }
}