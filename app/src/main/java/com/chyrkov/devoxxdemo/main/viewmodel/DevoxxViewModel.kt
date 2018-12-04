package com.chyrkov.devoxxdemo.main.viewmodel

import androidx.lifecycle.ViewModel
import com.chyrkov.devoxxdemo.misc.ClicksLiveData

class DevoxxViewModel(val devoxxLiveData: DevoxxLiveData) : ViewModel() {

    val clicks = ClicksLiveData()

    fun onAddClicked() {
        clicks.postValue(true)
    }
}