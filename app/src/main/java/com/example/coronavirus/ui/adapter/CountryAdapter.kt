package com.example.coronavirus.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavirus.R
import com.example.coronavirus.data.Regions
import com.example.coronavirus.databinding.RowLayoutBinding


class CountryListAdapter : ListAdapter<Regions, RecyclerView.ViewHolder>(
    CountryDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolder).bind(getItem(position))


    inner class ViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private val name: TextView = itemView.findViewById(R.id.country_name)
        fun bind(regions: Regions) {

            binding.country = regions
            name.text = regions.france!!.name

        }
    }
}

class CountryDiffCallback : DiffUtil.ItemCallback<Regions>() {
    override fun areItemsTheSame(oldItem: Regions, newItem: Regions) = oldItem.france!!.name == newItem.france!!.name
    override fun areContentsTheSame(oldItem: Regions, newItem: Regions) = oldItem.france!!.name == newItem.france!!.name
}