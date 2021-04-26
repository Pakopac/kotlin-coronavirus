package com.example.coronavirus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavirus.R
import com.example.coronavirus.models.Country
import com.example.coronavirus.databinding.RowLayoutBinding

class CountryListAdapter() : ListAdapter<Country, RecyclerView.ViewHolder>(
    CountryDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolder).bind(getItem(position))


    inner class ViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {

            binding.country = country

        }
    }
}

class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem.id == newItem.id
}