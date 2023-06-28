package com.jakubu9333.bestartists.Get_Artists_Page

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakubu9333.bestartists.ArtistListAdapter
import com.jakubu9333.bestartists.AuthSpotify
import com.jakubu9333.bestartists.SpotifyViewModel
import com.jakubu9333.bestartists.databinding.FragmentSecondBinding
import com.jakubu9333.bestartists.main_page.MainApp
import com.jakubu9333.bestartists.vievmodels.EntryViewModel
import com.jakubu9333.bestartists.vievmodels.EntryViewModelFactory


class SecondFragment : Fragment() {

    private val apiViewModel: SpotifyViewModel by viewModels()
    private val dbViewModel: EntryViewModel by activityViewModels {
        EntryViewModelFactory(
            (activity?.application as MainApp).database.entryDatabaseDao
        )
    }

    private fun auth() {
        startActivity(Intent(activity, AuthSpotify::class.java))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentSecondBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        val recyclerView = binding.artistListView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ArtistListAdapter()
        recyclerView.adapter = adapter


        val key = activity?.getSharedPreferences("SPOTIFY", 0)?.getString("token", null)

        auth()
        if (key != null) {
            apiViewModel.getBestArtist(key, adapter, dbViewModel)
        }




        binding.viewModel = apiViewModel
        return binding.root
    }


}