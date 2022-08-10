package com.jakubu9333.bestartists

import android.content.Intent
import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @author Jakub Uhlarik
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val shared = getSharedPreferences("SPOTIFY", 0)
        var key = shared.getString("token", null)
        while (key == null) {
            startActivity(Intent(this, AuthSpotify::class.java))
            key=shared.getString("token", null)
        }

    }
}