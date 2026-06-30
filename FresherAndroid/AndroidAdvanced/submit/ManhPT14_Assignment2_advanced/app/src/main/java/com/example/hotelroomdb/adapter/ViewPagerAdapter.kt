package com.example.hotelroomdb.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hotelroomdb.fragment.ClientListFragment
import com.example.hotelroomdb.fragment.OccupationListFragment
import com.example.hotelroomdb.fragment.RoomListFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> RoomListFragment()
        1 -> ClientListFragment()
        else -> OccupationListFragment()
    }
}
