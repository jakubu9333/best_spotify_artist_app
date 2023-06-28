package com.jakubu9333.bestartists.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

/**
 *
 * @author Jakub Uhlarik
 */


@Entity(
    tableName = "entry_artist_join_table",
    primaryKeys = ["entryIdRef", "artistIdRef"],
    foreignKeys = [
        ForeignKey(
            entity = PastEntry::class,
            parentColumns = ["entryId"],
            childColumns = ["entryIdRef"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = ["artistId"],
            childColumns = ["artistIdRef"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EntriesArtistsMap(
    val entryIdRef: Long,
    @ColumnInfo(index = true)
    val artistIdRef: String
)
