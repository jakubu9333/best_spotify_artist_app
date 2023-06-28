package com.jakubu9333.bestartists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.database.ArtistEntity
import com.jakubu9333.bestartists.databinding.SecondTextItemBinding

/**
 *
 * @author Jakub Uhlarik
 */
class ArtistListAdapter : ListAdapter<ArtistEntity, ArtistListAdapter.ItemViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<ArtistEntity>() {
        override fun areItemsTheSame(oldItem: ArtistEntity, newItem: ArtistEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ArtistEntity, newItem: ArtistEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class ItemViewHolder(private var binding: SecondTextItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: ArtistEntity) {
            // binding.artist=artist
            binding.artistText.text = artist.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = SecondTextItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val art = getItem(position)
        holder.bind(art)
    }
}
