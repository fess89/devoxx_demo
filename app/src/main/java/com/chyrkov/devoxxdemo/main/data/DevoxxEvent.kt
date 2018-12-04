package com.chyrkov.devoxxdemo.main.data

import android.os.Parcelable
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
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
) : Parcelable