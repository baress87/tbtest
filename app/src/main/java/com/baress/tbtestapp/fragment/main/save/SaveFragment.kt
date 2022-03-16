package com.baress.tbtestapp.fragment.main.save

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baress.tbtestapp.R
import com.baress.tbtestapp.databinding.FragmentSaveBinding
import com.baress.tbtestapp.fragment.base.BaseFragment
import javax.inject.Inject

class SaveFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: FragmentSaveBinding
    private val saveViewModel: SaveViewModel by viewModels { factory }

    private val adapter: SaveAdapter = SaveAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_save, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saveViewModel.saveList.observe(viewLifecycleOwner) {
            adapter.setListItem(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        saveViewModel.getSaveList()
    }

    companion object {
        fun newInstance(): SaveFragment = SaveFragment()
    }
}
