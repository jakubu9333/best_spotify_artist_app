package com.jakubu9333.bestartists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.database.PastEntry
import com.jakubu9333.bestartists.databinding.EntryItemBinding
import com.jakubu9333.bestartists.vievmodels.EntryViewModel
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author Jakub Uhlarik
 */
class MainViewAdapter(private val entryViewModel: EntryViewModel) : ListAdapter<PastEntry, MainViewAdapter.EntryViewHolder>(DiffCallback){
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PastEntry>() {
            override fun areItemsTheSame(oldItem: PastEntry, newItem: PastEntry): Boolean {
                return oldItem.entry_id == newItem.entry_id
            }

            override fun areContentsTheSame(oldItem: PastEntry, newItem: PastEntry): Boolean {
                return oldItem == newItem
            }
        }
    }


    class EntryViewHolder(private var binding: EntryItemBinding,private var viewModel: EntryViewModel): RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("SimpleDateFormat")
            fun bind(entry:PastEntry){
                binding.idText.text=entry.entry_id.toString()
                binding.entrytext.text= SimpleDateFormat(
                    "HH:mm dd.MM").format(Date(entry.time))
                binding.deleteButton.setOnClickListener{
                    viewModel.onDeleteEntry(entry.entry_id)
                }
            }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder(EntryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),entryViewModel)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}