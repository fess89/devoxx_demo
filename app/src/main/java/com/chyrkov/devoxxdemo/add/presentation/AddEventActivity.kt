package com.chyrkov.devoxxdemo.add.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.chyrkov.devoxxdemo.R
import com.chyrkov.devoxxdemo.databinding.ActivityAddEventBinding

class AddEventActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_event)
    }
}