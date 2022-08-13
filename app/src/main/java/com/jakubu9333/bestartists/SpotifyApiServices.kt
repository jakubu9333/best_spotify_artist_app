package com.jakubu9333.bestartists

import com.jakubu9333.bestartists.jsonmodels.Artist
import com.jakubu9333.bestartists.jsonmodels.Artists
import com.jakubu9333.bestartists.jsonmodels.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET
import retrofit2.http.Header

/**
 *
 * @author Jakub Uhlarik
 */

private val BASE_URL =
    "https://api.spotify.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface SpotifyApiServices {
    @GET("me")
    suspend fun getMe(@Header("Authorization") authorization: String): User

    @GET("me/top/artists")
    suspend fun getTopArtists(@Header("Authorization") authorization: String):Artists
}


object SpotifyApi {
    val retrofitService: SpotifyApiServices by lazy {
        retrofit.create(SpotifyApiServices::class.java)
    }
}
