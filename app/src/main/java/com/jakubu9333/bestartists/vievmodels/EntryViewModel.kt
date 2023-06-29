package com.jakubu9333.bestartists.vievmodels

import androidx.lifecycle.ViewModel

import com.jakubu9333.bestartists.database.AllDao
import com.jakubu9333.bestartists.database.ArtistEntity
import com.jakubu9333.bestartists.database.EntriesArtistsMap
import com.jakubu9333.bestartists.database.PastEntry
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


import kotlinx.coroutines.flow.Flow


/**
 *
 * @author Jakub Uhlarik
 */
class EntryViewModel(
    val database: AllDao
) : ViewModel() {
    var entries: Flow<List<PastEntry>>? = null
    var artists: Flow<List<ArtistEntity>>? = null

    fun getArtistsByEntry(entryId: Long): Flow<List<ArtistEntity>>? {
        artists = database.getArtistsByEntry(entryId)
        return artists
    }

    fun getAllEnt(): Flow<List<PastEntry>>? {
        entries = database.getAllEntries()
        return entries
    }

    fun onNewEntry() {
        GlobalScope.launch {
            newEntry()
        }

    }

    fun onArtists(artistEntityList: List<ArtistEntity>?) {
        GlobalScope.launch {
            if (artistEntityList != null) {
                insertArtists(artistEntityList)
            }
        }
    }

    fun onDeleteEntry(id: Long) {
        GlobalScope.launch {
            deleteEntry(id)
        }
    }

    suspend fun deleteEntry(id: Long) {
        database.clearEntry(id)
    }

    suspend fun insertArtists(artistEntity: List<ArtistEntity>) {
        database.insertArtists(artistEntity)
    }


    suspend fun newEntry():Long {
        return database.insertEntry(PastEntry())
    }


    fun onClear() {
        GlobalScope.launch {
            clear()
        }

    }

    suspend fun clear() {
        database.clear()
    }

    suspend fun instertArtistWithMapping(artists: List<ArtistEntity>) {
            database.insertEntryWitArtists(artists)

    }

    fun onAddMappingswithNewEntry(artistEntityList: List<ArtistEntity>?) {
        GlobalScope.launch {
            if (artistEntityList != null) {
                instertArtistWithMapping(artistEntityList)
            }

        }


    }


}