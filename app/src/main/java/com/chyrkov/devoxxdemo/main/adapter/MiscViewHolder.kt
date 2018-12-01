package com.chyrkov.devoxxdemo.main.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import com.chyrkov.devoxxdemo.BR
import com.chyrkov.devoxxdemo.databinding.AdapterItemMiscBinding

class MiscViewHolder(val view: View) : DevoxxViewHolder(view) {

    private val binding: AdapterItemMiscBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: DevoxxAdapterItem) {
        binding.setVariable(BR.event, item)
        binding.executePendingBindings()
    }
}