package com.chyrkov.devoxxdemo.app

import androidx.multidex.MultiDexApplication
import com.chyrkov.devoxxdemo.di.KoinModules
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.android.startKoin

class DevoxxApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, KoinModules().getModules())
        JodaTimeAndroid.init(this);
    }
}