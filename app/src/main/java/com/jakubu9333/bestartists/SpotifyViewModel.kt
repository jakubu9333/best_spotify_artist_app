package com.jakubu9333.bestartists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakubu9333.bestartists.jsonmodels.Artist
import kotlinx.coroutines.launch

/**
 *
 * @author Jakub Uhlarik
 */
class SpotifyViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists
    fun getInfoAboutMe(auth: String) {
        viewModelScope.launch {
            try {
                val res = SpotifyApi.retrofitService.getMe("Bearer $auth")
                _status.value = res.name
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
        return
    }


    fun getBestArtist(auth: String){

        viewModelScope.launch {

            try {
                 val res = SpotifyApi.retrofitService.getTopArtists("Bearer $auth")
                _artists.value = res.items
                _status.value=res.items.toString()
            } catch (e: Exception) {
               _status.value=  "Failure: ${e.message}"
            }

        }
    }


}