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

class RecyclerAdapter(private val dataList:MutableList<Country>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private  lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        val countryName = holder.itemView.country_name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Country) {
            with(itemView) {
                country_name.text = item.name
            }
        }
    }
}
