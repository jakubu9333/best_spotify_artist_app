package com.jakubu9333.bestartists.jsonmodels

import com.squareup.moshi.Json

/**
 *
 * @author Jakub Uhlarik
 */
data class User (
    @Json(name="display_name")
    val name:String=""
)

