package com.example.desafiobeertech.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiobeertech.R
import com.example.desafiobeertech.entities.ItemProduct


class ProductItemAdapter: RecyclerView.Adapter<ProductItemAdapter.ProductItemViewHolder>() {
    var data = listOf<ItemProduct>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class ProductItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productItem: TextView = itemView.findViewById(R.id.productTextView)
        val descriptionItem: TextView = itemView.findViewById(R.id.descriptionTextView)
        val priceItem: TextView = itemView.findViewById(R.id.priceTextView)
        val imageItem: ImageView = itemView.findViewById(R.id.ItemImage)

        fun bind(product: String, description: String, price: Double, url: String){
            productItem.text = product
            descriptionItem.text = description
            priceItem.text = price
            val url: String = url

            if(url.isNotEmpty()) {
                Glide.with(itemView.context)
                        .load(url)
                        .placeholder(R.drawable.colorado_beer)
                        .error(R.drawable.colorado_beer)
                        .into(imageItem)
            }else {
                Glide.with(itemView.context).clear(itemView)
                imageItem.setImageResource(R.drawable.colorado_beer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_product, parent, false)
        return ProductItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val itemProductToShow: ItemProduct = data.get(position)
        holder.bind(itemProductToShow.product, itemProductToShow.description, itemProductToShow.price, itemProductToShow.image)
    }
}