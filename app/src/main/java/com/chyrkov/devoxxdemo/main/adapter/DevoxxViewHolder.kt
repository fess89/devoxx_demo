package com.chyrkov.devoxxdemo.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class DevoxxViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: DevoxxAdapterItem)

}