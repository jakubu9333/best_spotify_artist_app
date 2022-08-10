package com.jakubu9333.bestartists

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

/**
 *
 * @author Jakub Uhlarik
 */
class AuthSpotify : AppCompatActivity() {
    private val REQUEST_CODE = 420
    private val REDIRECT_URI = "com-jakubu9333-bestartist://callback"
    private val CLIENT_ID = "f61c6f74ab4a403e9a69cba0648c324f"

    private fun authenticate() {
        val builder = AuthorizationRequest.Builder(
            CLIENT_ID,
            AuthorizationResponse.Type.TOKEN,
            REDIRECT_URI
        )
        builder.setScopes(arrayOf("user-top-read"))
        val request = builder.build()
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authenticate()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, data)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    val editor = getSharedPreferences("SPOTIFY", 0).edit()
                    editor.putString("token", response.accessToken)
                    editor.apply()
                    Log.d("STARTING", "GOT AUTH TOKEN")
                }
                AuthorizationResponse.Type.ERROR -> {
                    Log.d("STARTING", "err")
                }
                else -> {
                    Log.d("kk", "ll")
                }
            }
            goBack()
        }
    }

    private fun goBack() {
        finish()
    }
}