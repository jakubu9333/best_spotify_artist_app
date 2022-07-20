package com.jakubu9333.bestartists.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 *
 * @author Jakub Uhlarik
 */
data class ArtistWithEntriesList(
    @Embedded
    val artist: ArtistEntity,
    @Relation(
        entity = PastEntry::class,
        parentColumn = "artistId",
        entityColumn = "entryId",
        associateBy = Junction(
            value = EntriesArtistsMap::class,
            parentColumn = "artistIdRef",
            entityColumn = "entryIdRef"
        )
    )
    val entryList: List<PastEntry>
)