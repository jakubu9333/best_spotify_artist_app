package com.jakubu9333.bestartists.jsonmodels

import com.jakubu9333.bestartists.database.ArtistEntity

/**
 *
 * @author Jakub Uhlarik
 */
data class Artist(
    val id:String,
    val name:String,
    val images:List<Image>
){
    fun getDatabaseArtist():ArtistEntity{
        val imgUrl= images[0].url
        return ArtistEntity(id,name,imgUrl)
    }

    override fun toString(): String {
        return "'$name'"
    }


}

