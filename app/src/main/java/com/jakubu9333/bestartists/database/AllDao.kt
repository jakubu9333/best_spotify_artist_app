package com.jakubu9333.bestartists.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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

    @Query("SELECT * from pastRequests WHERE entryId=:key")
    fun get(key: Long): PastEntry?

    @Query("DELETE FROM pastRequests")
    fun clear()

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC limit 1")
    fun getLastEntry():PastEntry

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC")
    fun getAllEntries(): LiveData<List<PastEntry>>

    @Query("SELECT * FROM artists")
    fun  getAllArtists(): List<ArtistEntity>

    @Query("SELECT * FROM pastRequests")
    fun getAllOutfits(): List<PastEntry>


    @Query("SELECT * FROM artists")
    fun getAllArtistsWithEntries(): List<ArtistWithEntriesList>

    @Query("SELECT * FROM pastRequests")
    fun getAllEntriesWithArtists(): List<EntriesWithArtistsList>

}