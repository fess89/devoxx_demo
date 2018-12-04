package com.chyrkov.devoxxdemo.add.presentation

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.chyrkov.devoxxdemo.BR
import com.chyrkov.devoxxdemo.databinding.FragmentAddEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddEventFragment : Fragment() {

    private val addEventViewModel: AddEventViewModel by viewModel()

    private lateinit var binding: FragmentAddEventBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddEventBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, addEventViewModel)
        binding.setVariable(BR.binding, addEventViewModel.binding)
        binding.executePendingBindings()

        addEventViewModel.clicks.observe(this, Observer<Boolean> {
            if (it) {
                activity?.apply {
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        })
    }
}