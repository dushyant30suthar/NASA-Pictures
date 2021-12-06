package com.dushyant30suthar.cleanarchitecture.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dushyant30suthar.cleanarchitecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}