package com.dushyant30suthar.nasapictures.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.dushyant30suthar.nasapictures.R.id
import com.dushyant30suthar.nasapictures.R.navigation
import com.dushyant30suthar.nasapictures.databinding.ActivityMainBinding


/*
* MainActivity/SingleActivity on which all application screens(Fragments/Views) relays on.*/
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        * Let the viewBinding do it's stuff.*/
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        * Using toolbar. */
        setSupportActionBar(binding.mainActivityToolbar)

        /*
        * Setting up navGraph.
        * Now flow has been passed to android navigation component.*/
        val navController =
            this.findNavController(id.mainActivityNavHostFragmentContainer)
        navController.setGraph(navigation.navigation_cosmos)
        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(id.mainActivityNavHostFragmentContainer)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(
            this,
            id.mainActivityNavHostFragmentContainer
        ).navigateUp() || super.onSupportNavigateUp())
    }
}