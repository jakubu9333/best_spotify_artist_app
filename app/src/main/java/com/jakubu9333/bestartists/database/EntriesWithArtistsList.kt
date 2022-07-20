package com.jakubu9333.bestartists.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 *
 * @author Jakub Uhlarik
 */
data class EntriesWithArtistsList(
    @Embedded
    val entry: PastEntry,
    @Relation(
        entity = ArtistEntity::class,
        parentColumn = "entryId",
        entityColumn = "artistId",
        associateBy = Junction(
            value = EntriesArtistsMap::class,
            parentColumn = "entryIdRef",
            entityColumn = "artistIdRef"
        )
    )
    val artistsList: List<ArtistEntity>
)

