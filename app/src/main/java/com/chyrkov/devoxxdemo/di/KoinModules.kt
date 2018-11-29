package com.chyrkov.devoxxdemo.di

import com.chyrkov.devoxxdemo.main.data.DevoxxRepository
import com.chyrkov.devoxxdemo.main.viewmodel.DevoxxLiveData
import com.google.firebase.database.FirebaseDatabase
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class KoinModules {

    private val mainModule = module {

        single { FirebaseDatabase.getInstance() }
        single { DevoxxRepository(get()) }
        single { DevoxxLiveData(get()) }

    }

    fun getModules(): List<Module> {
        return listOf(mainModule)
    }
}