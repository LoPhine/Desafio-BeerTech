package com.example.desafiobeertech.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiobeertech.entities.ItemProduct

class ProductItemAdapter: RecyclerView.Adapter<ProductItemAdapter.ProductItemViewHolder>() {
    var data = listOf<ItemProduct>()
    inner class ProductItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}