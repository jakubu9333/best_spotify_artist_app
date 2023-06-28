package com.jakubu9333.bestartists.View_artists_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakubu9333.bestartists.ArtistListAdapter
import com.jakubu9333.bestartists.databinding.FragmentViewArtistsBinding
import com.jakubu9333.bestartists.main_page.MainApp
import com.jakubu9333.bestartists.vievmodels.EntryViewModel
import com.jakubu9333.bestartists.vievmodels.EntryViewModelFactory
import kotlinx.coroutines.launch

/**
 *
 * @author Jakub Uhlarik
 */
class ViewArtistsFragment : Fragment() {

    private val viewModel: EntryViewModel by activityViewModels {
        EntryViewModelFactory(
            (activity?.application as MainApp).database.entryDatabaseDao
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val entityId = activity?.intent?.getLongExtra("entry_id", -1)


        val binding = FragmentViewArtistsBinding.inflate(inflater)
        val recyclerView = binding.artistListView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ArtistListAdapter()
        recyclerView.adapter = adapter

        lifecycle.coroutineScope.launch {
            if (entityId != null && entityId != -1L) {
                viewModel.getArtistsByEntry(entityId)?.collect() {
                    adapter.submitList(it)
                }
            }
        }





        return binding.root
    }
}