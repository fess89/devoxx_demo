package com.chyrkov.devoxxdemo.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DevoxxViewModel(val devoxxLiveData: DevoxxLiveData) : ViewModel() {

    val clicks: MutableLiveData<Boolean> = MutableLiveData()

    fun onAddClicked() {
        clicks.postValue(true)
        clicks.value = false
    }
}