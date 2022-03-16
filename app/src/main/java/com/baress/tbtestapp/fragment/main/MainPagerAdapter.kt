package com.baress.tbtestapp.fragment.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.baress.tbtestapp.fragment.main.recent.RecentFragment
import com.baress.tbtestapp.fragment.main.save.SaveFragment

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = MAIN_PAGER_COUNT

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> SaveFragment.newInstance()
            1 -> RecentFragment.newInstance()
            else -> throw IllegalArgumentException("Invalid view type : $position")
        }

    companion object {

        const val MAIN_PAGER_COUNT = 2
    }
}
