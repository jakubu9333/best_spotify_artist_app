package com.jakubu9333.bestartists

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.viewModelScope
import com.jakubu9333.bestartists.databinding.FragmentSecondBinding
import com.jakubu9333.bestartists.jsonmodels.Artist
import kotlinx.coroutines.launch


class SecondFragment : Fragment() {

    private val viewModel: SpotifyViewModel by viewModels()

    private fun auth() {
        startActivity(Intent(activity, AuthSpotify::class.java))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val bind = FragmentSecondBinding.inflate(inflater)
        bind.lifecycleOwner = viewLifecycleOwner
        val vm = viewModel

        //var success=false
        /* val handler = CoroutineExceptionHandler { _, exception ->
             println("CoroutineExceptionHandler got $exception")
         }*/

        auth()
        val key = activity?.getSharedPreferences("SPOTIFY", 0)?.getString("token", null)
        //bind.recycler.adapter=SecondTextAdapter()
        if (key != null) {
           vm.getBestArtist(key)
        }




        bind.viewModel=vm
        return bind.root
    }

}