package com.basiatish.hammersystemstestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MenuFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}