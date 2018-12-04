package com.chyrkov.devoxxdemo.misc

import androidx.lifecycle.MutableLiveData

class ClicksLiveData : MutableLiveData<Boolean>() {

    override fun onActive() {
        value = false
    }

    override fun onInactive() {
        value = false
    }
}