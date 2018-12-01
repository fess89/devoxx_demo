package com.chyrkov.devoxxdemo.main.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import com.chyrkov.devoxxdemo.main.data.DevoxxEvent
import org.joda.time.DateTime

class DevoxxAdapterItem(private val event: DevoxxEvent) {

    fun name(): String? {
        return event.name
    }

    fun lecturers(): String? {
        return event.lecturers?.joinToString()
    }

    fun location(): String? {
        return event.location
    }

    fun timeBounds(): String {
        val startDateTime = DateTime(event.startTime)
        val endDateTime = DateTime(event.endTime)
        return "%2d:%2d - %2d:%2d".format(
            startDateTime.hourOfDay().get(), startDateTime.minuteOfHour().get(),
            endDateTime.hourOfDay().get(), endDateTime.minuteOfHour().get()
        )
    }

    fun showLikes(): Boolean {
        return event.likes > 0
    }

    fun likes(): String {
        return event.likes.toString()
    }

    fun labelColor(context: Context): Int {
        return ContextCompat.getColor(context, event.type.colorResource())
    }
}