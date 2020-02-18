package com.example.intro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intro.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "first_time_app_launch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        val sharedPref = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        if (sharedPref.getBoolean(PREF_NAME, false)) {
            Toast.makeText(this, "Old User", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "First time login", Toast.LENGTH_LONG).show()
        }
    }

}
