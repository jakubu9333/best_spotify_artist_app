package com.jakubu9333.bestartists.main_page


import android.app.Application
import com.jakubu9333.bestartists.database.EntriesDatabase


/**
 *
 * @author Jakub Uhlarik
 */
class MainApp : Application() {
    val database: EntriesDatabase by lazy { EntriesDatabase.getInstance(this) }
}