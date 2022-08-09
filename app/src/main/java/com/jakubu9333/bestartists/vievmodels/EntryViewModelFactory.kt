package com.jakubu9333.bestartists.vievmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jakubu9333.bestartists.database.AllDao

/**
 *
 * @author Jakub Uhlarik
 */
class EntryViewModelFactory(
    private val dataSource: AllDao,
) : ViewModelProvider.Factory {


    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EntryViewModel::class.java)) {
            return EntryViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
