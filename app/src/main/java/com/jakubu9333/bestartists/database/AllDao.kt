package com.jakubu9333.bestartists.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/**
 *
 * @author Jakub Uhlarik
 */


@Dao
interface AllDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(entry: PastEntry)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArtist(artist: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArtists(artists: List<ArtistEntity>)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMapping(mapping:EntriesArtistsMap)

    @Query("SELECT * from pastRequests WHERE entryId=:key")
    fun get(key: Long): PastEntry?

    @Query("DELETE FROM pastRequests where entryId=:key")
    fun clearEntry(key: Long)
    @Query("DELETE FROM pastRequests")
    fun clear()

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC limit 1")
    fun getLastEntry():PastEntry

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC")
    fun getAllEntries(): Flow<List<PastEntry>>


    @Query("SELECT * FROM artists")
    fun getAllArtistsWithEntries(): List<ArtistWithEntriesList>

    @Query("SELECT * FROM pastRequests where entryId=:key")
    fun getEntryWithArtists(key: Long): EntriesWithArtistsList

}