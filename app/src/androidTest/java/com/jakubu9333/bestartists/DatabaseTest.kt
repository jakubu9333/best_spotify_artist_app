package com.jakubu9333.bestartists

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jakubu9333.bestartists.database.EntriesDatabase
import com.jakubu9333.bestartists.database.AllDao
import com.jakubu9333.bestartists.database.PastEntry
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.LinkedList

/**
 *
 * @author Jakub Uhlarik
 */


@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var dao: AllDao
    private lateinit var db: EntriesDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, EntriesDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        dao = db.entryDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndCheckArtist() {
        val test = Artist("Future").toEntity()
       // val entry = PastEntry(artists = checklist);

        dao.insertArtist(test)
        val last = dao.getAllArtists()[0]
        assertEquals(last.name,"Future")

    }
}
