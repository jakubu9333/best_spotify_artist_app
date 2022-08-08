package com.jakubu9333.bestartists.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



/**
 *
 * @author Jakub Uhlarik
 */

@Entity(tableName = "pastRequests")
data class PastEntry(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "entryId")
    var entry_id :Long = 0L,
    @ColumnInfo(name="time")
    var time: Long = System.currentTimeMillis()
)
