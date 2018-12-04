package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.firestore.*

class DevoxxRepository(private val firestore: FirebaseFirestore) {

    private var registration: ListenerRegistration? = null

    fun subscribe(listener: (List<DevoxxEvent>) -> Unit) {
        registration = firestore
            .collection(EVENTS)
            .orderBy(START_TIME, Query.Direction.ASCENDING)
            .addSnapshotListener(EventListener<QuerySnapshot> { snapshot, _ ->
                if (snapshot == null) {
                    return@EventListener
                }
                val list = snapshot.documents
                    .map { it -> it.toObject(DevoxxEvent::class.java)!! }
                    .toList()
                listener.invoke(list)
            })
    }

    fun addEvent(event: DevoxxEvent) {
        firestore.collection(EVENTS).add(event)
    }

    fun unsubscribe() {
        registration?.remove()
    }

    companion object {
        const val EVENTS = "events"
        const val START_TIME = "startTime"
    }
}