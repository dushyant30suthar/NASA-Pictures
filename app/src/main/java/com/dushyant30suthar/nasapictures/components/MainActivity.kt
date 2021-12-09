package com.dushyant30suthar.nasapictures.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.databinding.ActivityMainBinding

/*
* MainActivity/SingleActivity on which all application screens(Fragments/Views) relays on.*/
class MainActivity : AppCompatActivity() {

    /*
    * This project uses ViewBinding not the whole DataBinding stuff. */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        * Let the viewBinding do it's stuff.*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        * Using toolbar. */
        setSupportActionBar(binding.mainActivityToolbar)

        /*
        * Setting up navGraph.
        * Now flow has been passed to android navigation component.*/
        val navController = this.findNavController(R.id.mainActivityNavHostFragmentContainer)
        navController.setGraph(R.navigation.navigation_cosmos)
    }
}