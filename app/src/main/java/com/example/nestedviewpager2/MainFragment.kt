package com.example.nestedviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView: View = inflater.inflate(R.layout.fragment_main, container, false)

        val tabLayout: TabLayout = rootView.findViewById(R.id.main_tab_layout)
        val pagerAdapter = ScreenSlidePagerAdapter(this@MainFragment)

        val viewPager: ViewPager2 = rootView.findViewById(R.id.main_view_pager)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "1"
                1 -> tab.text = "2"
            }
        }.attach()

        return rootView
    }

    private inner class ScreenSlidePagerAdapter(fragmentActivity: MainFragment) : FragmentStateAdapter(
        fragmentActivity
    ) {
        override fun getItemCount(): Int = 2 //because we have two Fragments

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                Fragment1()
            } else {
                Fragment2()
            }
        }
    }
}