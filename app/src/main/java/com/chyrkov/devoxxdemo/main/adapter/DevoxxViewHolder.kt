package com.chyrkov.devoxxdemo.main.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chyrkov.devoxxdemo.databinding.AdapterItemDevoxxBinding
import com.chyrkov.devoxxdemo.main.data.DevoxxAdapterItem

class DevoxxViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: AdapterItemDevoxxBinding = DataBindingUtil.bind(view)!!

    fun bind(item: DevoxxAdapterItem) {
        binding.itemNameTextview.text = item.text
    }
}