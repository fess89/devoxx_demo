package com.chyrkov.devoxxdemo.main.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DevoxxRepository(private val firebaseDatabase: FirebaseDatabase) {

    class EventsListener(private val listener: (List<DevoxxEvent>) -> Unit) : ValueEventListener {

        override fun onDataChange(snapshot: DataSnapshot) {
            val list = snapshot.children
                .map { it.getValue(DevoxxEvent::class.java) }
                .map { it!! }
                .toList()
            listener.invoke(list)
        }

        override fun onCancelled(error: DatabaseError) {}
    }

    private var eventsListener: ValueEventListener? = null

    private val databaseReference = firebaseDatabase.getReference("events")

    fun subscribe(listener: (List<DevoxxEvent>) -> Unit) {
        this.eventsListener = EventsListener(listener)
        firebaseDatabase.getReference("events").addValueEventListener(eventsListener as EventsListener)
    }

    fun unsubscribe() {
        eventsListener?.let { databaseReference.removeEventListener(it) }
    }
}