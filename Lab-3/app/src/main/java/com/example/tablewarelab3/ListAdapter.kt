package com.example.tablewarelab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<ModelTableware>) : RecyclerView.Adapter<ListAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val Product = itemView.findViewById(R.id.Product) as TextView
        private  val Shop = itemView.findViewById(R.id.Shop) as TextView

        fun bind(item: ModelTableware) {
            Product.text = item.Product
            Shop.text = item.Shop
        }
    }

}