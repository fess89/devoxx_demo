package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class DevoxxEvent(
    val name: String? = "",
    val type: DevoxxEventType = DevoxxEventType.UNDEFINED,
    val location: String? = "",
    val date: Date? = null,
    val startTime: Date? = null,
    val endTime: Date? = null,
    val lecturers: List<String>? = null,
    val likes: Int = 0
)