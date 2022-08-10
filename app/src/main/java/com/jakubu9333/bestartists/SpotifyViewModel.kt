package com.jakubu9333.bestartists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *
 * @author Jakub Uhlarik
 */
class SpotifyViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    fun getInfoAboutMe(auth: String) {

        viewModelScope.launch {

            try {
                val res = SpotifyApi.retrofitService.getMe("Bearer $auth")
                _status.value = res
            } catch (e: Exception) {

                _status.value = "Failure: ${e.message}"
            }

        }
    }
}