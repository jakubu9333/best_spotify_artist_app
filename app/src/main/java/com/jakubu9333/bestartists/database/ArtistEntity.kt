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
    val id :String,

    val name: String,
    val imageUrl: String,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArtistEntity

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}
