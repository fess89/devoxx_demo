package com.chyrkov.devoxxdemo.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chyrkov.devoxxdemo.R
import com.chyrkov.devoxxdemo.main.data.DevoxxEventType
import java.util.*

class DevoxxAdapter(private val items: MutableList<DevoxxAdapterItem> = ArrayList()) :
    RecyclerView.Adapter<DevoxxViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].eventType()) {
            DevoxxEventType.LECTURE -> 0
            DevoxxEventType.MISC -> 1
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevoxxViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> LectureViewHolder(inflater.inflate(R.layout.adapter_item_lecture, parent, false))
            else -> MiscViewHolder(inflater.inflate(R.layout.adapter_item_misc, parent, false))
        }
    }

    override fun onBindViewHolder(holder: DevoxxViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setData(data: Collection<DevoxxAdapterItem>) {
        // TODO use diffutil
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}