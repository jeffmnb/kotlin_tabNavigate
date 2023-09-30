package com.example.appwithtabnavigator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appwithtabnavigator.fragments.FeedFragment
import com.example.appwithtabnavigator.fragments.HomeFragment
import com.example.appwithtabnavigator.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    handleCallFragment(HomeFragment())
                }

                R.id.feed -> {
                    handleCallFragment(FeedFragment())
                }

                R.id.profile -> {
                    handleCallFragment(ProfileFragment())
                }

                else -> false
            }
        }

        handleCallFragment(HomeFragment())

    }

    private fun handleCallFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment).commit()
        return true
    }
}