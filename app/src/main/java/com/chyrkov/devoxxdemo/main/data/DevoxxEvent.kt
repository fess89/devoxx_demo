package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class DevoxxEvent(
        val eventType: String? = null,
        val name: String? = null,
        val topic: String? = null,
        val location: String? = null,
        val startTime: Date? = null,
        val endTime: Date? = null,
        val lecturers: List<String>? = null,
        val likes: Int = 0
)