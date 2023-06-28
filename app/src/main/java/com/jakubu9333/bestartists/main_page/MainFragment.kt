package com.jakubu9333.bestartists.main_page


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.Get_Artists_Page.SecondActivity
import com.jakubu9333.bestartists.databinding.FragmentMainFragmentBinding
import com.jakubu9333.bestartists.vievmodels.EntryViewModel
import com.jakubu9333.bestartists.vievmodels.EntryViewModelFactory
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private var _binding: FragmentMainFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private val viewModel: EntryViewModel by activityViewModels {
        EntryViewModelFactory(
            (activity?.application as MainApp).database.entryDatabaseDao
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFragmentBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MainViewListAdapter(viewModel, activity)
        recyclerView.adapter = adapter


        lifecycle.coroutineScope.launch {
            viewModel.getAllEnt()?.collect() {
                adapter.submitList(it)
            }
        }

        binding.getNewButton.setOnClickListener {

            startActivity(Intent(activity, SecondActivity::class.java))
            viewModel.onNewEntry()
        }
        binding.resetButton.setOnClickListener {
            viewModel.onClear()
        }


    }
}