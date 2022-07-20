package com.jakubu9333.bestartists.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author Jakub Uhlarik
 */

@Entity(tableName = "artists")
data class ArtistEntity(

    @PrimaryKey @ColumnInfo(name = "artistId")
    val uri :String,

    val name: String,
    val imageUrl: String,

)
