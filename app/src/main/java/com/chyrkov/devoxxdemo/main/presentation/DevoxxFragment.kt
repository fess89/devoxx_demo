package com.chyrkov.devoxxdemo.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chyrkov.devoxxdemo.databinding.FragmentMainBinding
import com.chyrkov.devoxxdemo.main.adapter.DevoxxAdapter
import com.chyrkov.devoxxdemo.main.data.DevoxxAdapterItem
import com.chyrkov.devoxxdemo.main.viewmodel.DevoxxViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DevoxxFragment : Fragment() {

    private val devoxxViewModel: DevoxxViewModel by viewModel()

    private lateinit var binding: FragmentMainBinding

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapter: DevoxxAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater)
        binding.recyclerView.layoutManager = linearLayoutManager
        adapter = DevoxxAdapter()
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        devoxxViewModel.liveData.observe(this, Observer<List<DevoxxAdapterItem>> {
            adapter.setData(it)
        })
    }
}