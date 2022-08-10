package com.jakubu9333.bestartists

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

/**
 *
 * @author Jakub Uhlarik
 */

    private val BASE_URL =
        "https://api.spotify.com/v1/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL).build()

    interface SpotifyApiServices {
        @GET("me")
        suspend fun getMe(@Header("Authorization") authorization:String): String
    }


    object SpotifyApi {
        val retrofitService: SpotifyApiServices by lazy { retrofit.create(SpotifyApiServices::class.java)
        }
    }
