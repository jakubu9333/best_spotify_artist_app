package com.jakubu9333.bestartists.Get_Artists_Page

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.jakubu9333.bestartists.AuthSpotify
import com.jakubu9333.bestartists.R

/**
 *
 * @author Jakub Uhlarik
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val shared = getSharedPreferences("SPOTIFY", 0)
        val key = shared.getString("token", null)
        if (key == null) {
            startActivity(Intent(this, AuthSpotify::class.java))
        }

    }
}