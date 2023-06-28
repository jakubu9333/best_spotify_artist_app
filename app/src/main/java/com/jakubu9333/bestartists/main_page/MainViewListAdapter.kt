package com.jakubu9333.bestartists.main_page

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.View_artists_page.ViewArtistActivity
import com.jakubu9333.bestartists.database.PastEntry
import com.jakubu9333.bestartists.databinding.EntryItemBinding
import com.jakubu9333.bestartists.vievmodels.EntryViewModel
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author Jakub Uhlarik
 */
class MainViewListAdapter(private val entryViewModel: EntryViewModel, private val context: Context?) :
    ListAdapter<PastEntry, MainViewListAdapter.EntryViewHolder>(
        DiffCallback
    ) {
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


    class EntryViewHolder(
        private var binding: EntryItemBinding,
        private var databaseModel: EntryViewModel,
        private var context: Context?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: PastEntry) {
            binding.idText.text = entry.entry_id.toString()
            binding.entrytext.text = SimpleDateFormat(
                "HH:mm dd.MM", Locale.ENGLISH
            ).format(Date(entry.time))
            binding.deleteButton.setOnClickListener {
                databaseModel.onDeleteEntry(entry.entry_id)
            }

            binding.checkButton.setOnClickListener {
                if (context != null) {
                    val intent = Intent(context!!, ViewArtistActivity::class.java)
                    startActivity(context!!, intent.putExtra("entry_id", entry.entry_id), Bundle())
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder(
            EntryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            entryViewModel,
            context
        )
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}