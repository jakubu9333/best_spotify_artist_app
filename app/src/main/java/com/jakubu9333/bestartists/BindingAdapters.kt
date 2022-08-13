package com.jakubu9333.bestartists

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakubu9333.bestartists.jsonmodels.Artist

/**
 *
 * @author Jakub Uhlarik
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Artist>?) {
    val adapter = recyclerView.adapter as SecondTextAdapter
    adapter.submitList(data)
}