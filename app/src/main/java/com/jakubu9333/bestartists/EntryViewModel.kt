package com.jakubu9333.bestartists

import androidx.lifecycle.ViewModel

import com.jakubu9333.bestartists.database.AllDao
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

    /*fun getEntriesCo(): Flow<List<PastEntry>>? {
        entries = null
        onAllOfTheEntries()
        while (entries == null) {
            var a = 1
        }
        return entries
    }*/

    fun onAllOfTheEntries() {
        GlobalScope.launch {
            getAllEnt()
        }
    }

    suspend fun getAllEnt(): Flow<List<PastEntry>>? {
        entries = database.getAllEntries()
        return entries
    }

    fun onNewEntry() {
        GlobalScope.launch {
            newEntry()
        }

    }

    suspend fun newEntry() {
        database.insertEntry(PastEntry())
    }


    fun onClear() {
        GlobalScope.launch {
            clear()
        }

    }

    suspend fun clear() {
        database.clear()
    }
}