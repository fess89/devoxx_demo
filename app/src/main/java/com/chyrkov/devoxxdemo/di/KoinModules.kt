package com.chyrkov.devoxxdemo.di

import com.chyrkov.devoxxdemo.add.presentation.AddEventViewModel
import com.chyrkov.devoxxdemo.main.data.DevoxxRepository
import com.chyrkov.devoxxdemo.main.viewmodel.DevoxxLiveData
import com.chyrkov.devoxxdemo.main.viewmodel.DevoxxViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class KoinModules {

    private val mainModule = module {

        single { FirebaseFirestore.getInstance() }
        single { DevoxxRepository(get()) }
        single { DevoxxLiveData(get()) }
        single { DevoxxViewModel(get()) }

    }

    private val addEventModule = module {

        single { AddEventViewModel() }

    }

    fun getModules(): List<Module> {
        return listOf(mainModule)
    }
}