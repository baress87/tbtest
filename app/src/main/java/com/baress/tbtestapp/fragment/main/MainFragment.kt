package com.baress.tbtestapp.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.baress.tbtestapp.R
import com.baress.tbtestapp.databinding.FragmentMainBinding
import com.baress.tbtestapp.fragment.base.BaseFragment
import com.google.android.material.tabs.TabLayout

class MainFragment : BaseFragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListeners()
    }

    private fun initView() {
        binding.fragmentPagerView.adapter = MainPagerAdapter(this)
        binding.fragmentPagerView.isUserInputEnabled = false
    }

    private fun initListeners() {
        binding.tabLayoutMenu.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    binding.fragmentPagerView.currentItem = it.position
                }
            }
        })
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}
