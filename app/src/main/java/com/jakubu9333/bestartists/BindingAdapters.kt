package com.jakubu9333.bestartists

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.database.ArtistEntity

/**
 *
 * @author Jakub Uhlarik
 */
@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<ArtistEntity>?
) {
    val adapter = recyclerView.adapter as ArtistListAdapter
    adapter.submitList(data)
}