package com.chyrkov.devoxxdemo.add.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.chyrkov.devoxxdemo.BR
import com.chyrkov.devoxxdemo.main.data.DevoxxEvent
import com.chyrkov.devoxxdemo.main.data.DevoxxEventType
import org.joda.time.DateTime

class AddEventBinding : BaseObservable() {

    private val eventType: DevoxxEventType = DevoxxEventType.LECTURE

    private val startTime = DateTime.now().toDate()

    private val endTime = DateTime.now().plusHours(1).toDate()

    private val lecturersList: List<String> = ArrayList()

    @Bindable
    var name: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.name)
            }
        }

    @Bindable
    var topic: String? = null
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.topic)
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

    fun getData(): DevoxxEvent {
        return DevoxxEvent(eventType.type, name, topic, location, startTime, endTime, lecturersList, 0)
    }
}