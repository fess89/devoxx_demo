package com.chyrkov.devoxxdemo.main.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chyrkov.devoxxdemo.BR
import com.chyrkov.devoxxdemo.add.presentation.AddEventActivity
import com.chyrkov.devoxxdemo.databinding.FragmentMainBinding
import com.chyrkov.devoxxdemo.main.adapter.DevoxxAdapter
import com.chyrkov.devoxxdemo.main.adapter.DevoxxAdapterItem
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
        binding.setVariable(BR.viewModel, devoxxViewModel)
        binding.executePendingBindings()

        devoxxViewModel.devoxxLiveData.observe(this, Observer<List<DevoxxAdapterItem>> {
            adapter.setData(it)
        })
        devoxxViewModel.clicks.observe(this, Observer<Boolean> { if (it) startAddActivity() })
    }

    private fun startAddActivity() {
        val intent = Intent(context, AddEventActivity::class.java)
        startActivityForResult(intent, 42)
    }
}