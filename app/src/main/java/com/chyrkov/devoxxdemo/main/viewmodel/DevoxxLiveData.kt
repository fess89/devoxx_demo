package com.chyrkov.devoxxdemo.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.chyrkov.devoxxdemo.main.data.DevoxxAdapterItem
import com.chyrkov.devoxxdemo.main.data.DevoxxEvent
import com.chyrkov.devoxxdemo.main.data.DevoxxRepository

class DevoxxLiveData(private val repo: DevoxxRepository) : MutableLiveData<List<DevoxxAdapterItem>>() {

    private val listener = { data: List<DevoxxEvent> ->
        value = data
            .asSequence()
            .map { DevoxxAdapterItem(it.name) }
            .toList()
    }

    override fun onActive() {
        super.onActive()
        repo.subscribe(listener)
    }

    override fun onInactive() {
        repo.unsubscribe()
        super.onInactive()
    }
}