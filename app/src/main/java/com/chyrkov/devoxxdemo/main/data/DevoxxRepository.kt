package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.QuerySnapshot

class DevoxxRepository(private val firestore: FirebaseFirestore) {

    private var registration: ListenerRegistration? = null

    fun subscribe(listener: (List<DevoxxEvent>) -> Unit) {
        registration = firestore
            .collection("events")
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

    fun unsubscribe() {
        registration?.remove()
    }
}