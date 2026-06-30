package com.example.hotelroomdb.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.example.hotelroomdb.R
import com.example.hotelroomdb.adapter.ViewPagerAdapter
import com.example.hotelroomdb.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.tab_rooms)
                1 -> getString(R.string.tab_clients)
                else -> getString(R.string.tab_occupations)
            }
        }.attach()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.navHostFragment.visibility == View.VISIBLE) {
                    if (!navController.navigateUp()) {
                        showMainTabs()
                    }
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                    isEnabled = true
                }
            }
        })
    }

    fun showOccupationForm() {
        showNavHost()
        navController.navigate(
            R.id.occupationFormFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.occupationFormFragment, inclusive = true)
                .build()
        )
    }

    fun showExpenseReport() {
        showNavHost()
        navController.navigate(
            R.id.expenseReportFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.occupationFormFragment, inclusive = true)
                .build()
        )
    }

    fun showRevenueReport() {
        showNavHost()
        navController.navigate(
            R.id.revenueReportFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.occupationFormFragment, inclusive = true)
                .build()
        )
    }

    private fun showNavHost() {
        binding.appBarLayout.visibility = View.GONE
        binding.viewPager.visibility = View.GONE
        binding.navHostFragment.visibility = View.VISIBLE
    }

    private fun showMainTabs() {
        binding.navHostFragment.visibility = View.GONE
        binding.viewPager.visibility = View.VISIBLE
        binding.appBarLayout.visibility = View.VISIBLE
    }
}
