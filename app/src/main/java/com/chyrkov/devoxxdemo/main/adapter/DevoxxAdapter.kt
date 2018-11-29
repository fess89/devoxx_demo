package com.chyrkov.devoxxdemo.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chyrkov.devoxxdemo.R
import com.chyrkov.devoxxdemo.main.data.DevoxxAdapterItem
import java.util.*

class DevoxxAdapter(val items: MutableList<DevoxxAdapterItem> = ArrayList()) :
    RecyclerView.Adapter<DevoxxViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevoxxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_devoxx, parent, false)
        return DevoxxViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
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