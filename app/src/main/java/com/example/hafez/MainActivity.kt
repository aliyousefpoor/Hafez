package com.example.hafez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mainNavHost: View
    private lateinit var homeNavHost: View
    private lateinit var listNavHost: View
    private lateinit var omenNavHost: View
    private lateinit var searchNavHost: View
    private lateinit var noteNavHost: View
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainNavHost = findViewById(R.id.mainNavHostFragment)
        homeNavHost = findViewById(R.id.homeNavHostFragment)
        listNavHost = findViewById(R.id.listNavHostFragment)
        omenNavHost = findViewById(R.id.omenNavHostFragment)
        searchNavHost = findViewById(R.id.searchNavHostFragment)
        noteNavHost = findViewById(R.id.noteNavHostFragment)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        navController = Navigation.findNavController(this, R.id.homeNavHostFragment)



        mainNavHost.visibility = View.GONE
        homeNavHost.visibility = View.VISIBLE
        listNavHost.visibility = View.GONE
        omenNavHost.visibility = View.GONE
        searchNavHost.visibility = View.GONE
        noteNavHost.visibility = View.GONE


        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    navController = Navigation.findNavController(this, R.id.homeNavHostFragment)
                    homeNavHost.visibility = View.VISIBLE
                    listNavHost.visibility = View.GONE
                    omenNavHost.visibility = View.GONE
                    searchNavHost.visibility = View.GONE
                    noteNavHost.visibility = View.GONE
                    mainNavHost.visibility = View.GONE
                    true
                }
                R.id.listFragment -> {
                    navController = Navigation.findNavController(this, R.id.listNavHostFragment)
                    listNavHost.visibility = View.VISIBLE
                    homeNavHost.visibility = View.GONE
                    omenNavHost.visibility = View.GONE
                    searchNavHost.visibility = View.GONE
                    noteNavHost.visibility = View.GONE
                    mainNavHost.visibility = View.GONE
                    true
                }
                R.id.omenFragment -> {
                    navController = Navigation.findNavController(this, R.id.omenNavHostFragment)
                    omenNavHost.visibility = View.VISIBLE
                    homeNavHost.visibility = View.GONE
                    listNavHost.visibility = View.GONE
                    searchNavHost.visibility = View.GONE
                    noteNavHost.visibility = View.GONE
                    mainNavHost.visibility = View.GONE
                    true
                }
                R.id.searchFragment -> {
                    navController = Navigation.findNavController(this, R.id.searchNavHostFragment)
                    searchNavHost.visibility = View.VISIBLE
                    homeNavHost.visibility = View.GONE
                    listNavHost.visibility = View.GONE
                    omenNavHost.visibility = View.GONE
                    noteNavHost.visibility = View.GONE
                    mainNavHost.visibility = View.GONE
                    true
                }
                R.id.noteFragment -> {
                    navController = Navigation.findNavController(this, R.id.noteNavHostFragment)
                    noteNavHost.visibility = View.VISIBLE
                    searchNavHost.visibility = View.GONE
                    homeNavHost.visibility = View.GONE
                    listNavHost.visibility = View.GONE
                    omenNavHost.visibility = View.GONE
                    mainNavHost.visibility = View.GONE
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}