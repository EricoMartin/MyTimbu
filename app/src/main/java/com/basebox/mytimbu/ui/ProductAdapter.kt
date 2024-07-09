package com.basebox.mytimbu.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.basebox.mytimbu.R
import com.basebox.mytimbu.models.Product
import com.bumptech.glide.Glide

class ProductAdapter (private val products: Product): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products.items[position]
        holder.textViewTitle.text = product.name
        holder.textViewPrice.text = product.currentPrice[0].nGN[0].toString()
        Glide.with(holder.itemView.context).load("https://api.timbu.cloud/images/${product.photos.first().url}").into(holder.imageView)
    }

    override fun getItemCount() = products.items.size
}