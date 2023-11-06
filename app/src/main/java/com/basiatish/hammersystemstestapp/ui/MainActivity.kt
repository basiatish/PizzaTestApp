package com.basiatish.hammersystemstestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.basiatish.hammersystemstestapp.R
import com.basiatish.hammersystemstestapp.ui.menu.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MenuFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}