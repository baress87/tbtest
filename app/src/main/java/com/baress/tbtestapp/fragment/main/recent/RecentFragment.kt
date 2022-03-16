package com.baress.tbtestapp.fragment.main.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baress.tbtestapp.R
import com.baress.tbtestapp.databinding.FragmentRecentBinding
import com.baress.tbtestapp.fragment.base.BaseFragment
import javax.inject.Inject

class RecentFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: FragmentRecentBinding
    private val recentViewModel: RecentViewModel by viewModels { factory }

    private val adapter: RecentAdapter = RecentAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recent, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recentViewModel.recentList.observe(viewLifecycleOwner) {
            adapter.setListItem(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        recentViewModel.getRecentList()
    }

    companion object {
        fun newInstance(): RecentFragment = RecentFragment()
    }
}
