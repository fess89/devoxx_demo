package com.chyrkov.devoxxdemo.add.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chyrkov.devoxxdemo.databinding.FragmentAddEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddEventFragment : Fragment() {

    private val addEventViewModel: AddEventViewModel by viewModel()

    private lateinit var binding: FragmentAddEventBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddEventBinding.inflate(inflater)
        return binding.root
    }
}