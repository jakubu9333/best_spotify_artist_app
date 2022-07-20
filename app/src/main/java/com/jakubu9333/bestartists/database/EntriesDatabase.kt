package com.jakubu9333.bestartists.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *
 * @author Jakub Uhlarik
 */


@Database(entities = [PastEntry::class,ArtistEntity::class,EntriesArtistsMap::class], version = 1, exportSchema = false)
abstract class EntriesDatabase : RoomDatabase() {

    abstract val entryDatabaseDao: AllDao


    companion object {
        @Volatile
        private var INSTANCE: EntriesDatabase? = null

        fun getInstance(context: Context): EntriesDatabase {
            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, EntriesDatabase::class.java,

                        "past_requests_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}