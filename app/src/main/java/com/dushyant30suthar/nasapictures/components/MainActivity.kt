package com.dushyant30suthar.nasapictures.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dushyant30suthar.nasapictures.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.mainActivityNavHostFragmentContainer)
        navController.setGraph(R.navigation.navigation_cosmos)
    }
}