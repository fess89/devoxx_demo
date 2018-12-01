package com.chyrkov.devoxxdemo.app

import androidx.multidex.MultiDexApplication
import com.chyrkov.devoxxdemo.di.KoinModules
import org.koin.android.ext.android.startKoin

class DevoxxApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, KoinModules().getModules())
    }
}