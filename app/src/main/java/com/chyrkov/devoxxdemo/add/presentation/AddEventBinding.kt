package com.chyrkov.devoxxdemo.add.presentation

import android.widget.RadioGroup
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.chyrkov.devoxxdemo.BR
import com.chyrkov.devoxxdemo.R
import com.chyrkov.devoxxdemo.main.data.DevoxxEvent
import com.chyrkov.devoxxdemo.main.data.DevoxxEventType
import org.joda.time.DateTime

class AddEventBinding : BaseObservable() {

    private var eventType: DevoxxEventType = DevoxxEventType.LECTURE

    private val startTime = DateTime.now().toDate()

    private val endTime = DateTime.now().plusHours(1).toDate()

    @Bindable
    var name: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.name)
                notifyPropertyChanged(BR.dataReady)
            }
        }

    @Bindable
    var topic: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.topic)
                notifyPropertyChanged(BR.dataReady)
            }
        }

    @Bindable
    var location: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.location)
            }
        }

    @Bindable
    var lecturers: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.lecturers)
            }
        }

    @Bindable
    var dataReady: Boolean = false
        get() {
            if (name.isNullOrBlank()) return false
            if (location.isNullOrBlank()) return false
            if (lecturers.isNullOrBlank()) return false
            if (topic.isNullOrBlank()) return false
            return true
        }

    fun onEventTypeChanged(radioGroup: RadioGroup, id: Int) {
        eventType = if (id == R.id.lecture_radiobutton) DevoxxEventType.LECTURE else DevoxxEventType.MISC
    }

    fun getData(): DevoxxEvent {
        val lecturersList = lecturers?.split(",")
        return DevoxxEvent(eventType.type, name, topic, location, startTime, endTime, lecturersList, 0)
    }
}