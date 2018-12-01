package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*
import kotlin.collections.ArrayList

@IgnoreExtraProperties
data class DevoxxEvent(
    val name: String? = "",
    val location: String? = "",
    val time: Date? = null,
    val lecturers: List<String>? = ArrayList()
)