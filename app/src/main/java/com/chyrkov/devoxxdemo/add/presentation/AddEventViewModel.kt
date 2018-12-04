package com.chyrkov.devoxxdemo.add.presentation

import androidx.lifecycle.ViewModel
import com.chyrkov.devoxxdemo.main.data.DevoxxRepository
import com.chyrkov.devoxxdemo.misc.ClicksLiveData

class AddEventViewModel(private val repo: DevoxxRepository) : ViewModel() {

    val binding = AddEventBinding()

    val clicks = ClicksLiveData()

    fun onReadyClicked() {
        repo.addEvent(binding.getData())
        clicks.postValue(true)
    }
}