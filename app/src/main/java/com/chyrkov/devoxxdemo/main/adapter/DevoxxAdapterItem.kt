package com.chyrkov.devoxxdemo.main.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import com.chyrkov.devoxxdemo.main.data.DevoxxEvent
import com.chyrkov.devoxxdemo.main.data.DevoxxEventType
import com.chyrkov.devoxxdemo.main.data.LectureTopic
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class DevoxxAdapterItem(private val event: DevoxxEvent) {

    fun eventType(): DevoxxEventType {
        return DevoxxEventType.fromString(event.eventType)
    }

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
        val start = event.startTime?.let { pattern.print(it.time) } ?: ""
        val end = event.endTime?.let { pattern.print(it.time) } ?: ""
        return "$start - $end"
    }

    fun showLikes(): Boolean {
        return event.likes > 0
    }

    fun likes(): String {
        return event.likes.toString()
    }

    fun labelColor(context: Context): Int {
        val topic = LectureTopic.fromString(event.topic)
        return ContextCompat.getColor(context, topic.colorResource())
    }

    companion object {
        val pattern: DateTimeFormatter = DateTimeFormat.forPattern("hh:mma")
    }
}