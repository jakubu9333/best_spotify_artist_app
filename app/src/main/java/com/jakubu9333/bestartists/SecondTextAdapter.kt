package com.jakubu9333.bestartists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.databinding.SecondTextItemBinding
import com.jakubu9333.bestartists.jsonmodels.Artist

/**
 *
 * @author Jakub Uhlarik
 */
class SecondTextAdapter: ListAdapter<Artist,SecondTextAdapter.ItemViewHolder>(DiffCallback){
    companion object DiffCallback : DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class ItemViewHolder(private var binding: SecondTextItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist){
            binding.artist=artist


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = SecondTextItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(adapterLayout)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val art=getItem(position)
        holder.bind(art)
    }
}
