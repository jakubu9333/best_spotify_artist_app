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

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArtistEntity

        if (uri != other.uri) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uri.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}
