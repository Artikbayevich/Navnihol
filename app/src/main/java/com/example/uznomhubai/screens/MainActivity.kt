package com.example.uznomhubai.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.ActivityMainBinding
import com.example.uznomhubai.screens.fragments.HomeFragment
import com.example.uznomhubai.screens.fragments.SavedFragment
import com.example.uznomhubai.screens.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_home -> replaceFragment(HomeFragment())

                R.id.bottom_saved -> replaceFragment(SavedFragment())

                R.id.bottom_settings -> replaceFragment(SettingsFragment())

                else -> replaceFragment(HomeFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

    fun hideBottomNavigation() {
        binding.bottomNavigation.visibility = View.GONE
        binding.bottomView.visibility = View.GONE
    }

    fun showBottomNavigation() {
        binding.bottomNavigation.visibility = View.VISIBLE
        binding.bottomView.visibility = View.VISIBLE
    }
}