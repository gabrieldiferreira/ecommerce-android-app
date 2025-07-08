package com.renarosantos.ecommerceapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.renarosantos.ecommerceapp.data.model.ProductCardViewState
import com.renarosantos.ecommerceapp.R
import com.renarosantos.ecommerceapp.databinding.ProductCardBinding

class ProductCardListAdapter(val onItemClicked: (ProductCardViewState) -> Unit) :
    RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {

    private var data: List<ProductCardViewState> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<ProductCardViewState>) {
        this.data = productList
        //notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productCardViewState: ProductCardViewState) {
            val bind = ProductCardBinding.bind(itemView)
            itemView.setOnClickListener {
                onItemClicked(productCardViewState)
            }
            bind.apply {
                bind.viewProductName.text = productCardViewState.title
                bind.viewProductDescription.text = productCardViewState.description
                bind.productPrice.text = productCardViewState.price
                Glide
                    .with(bind.productImage)
                    .asBitmap()
                    .load(productCardViewState.imageUrl)
                    .into(BitmapImageViewTarget(bind.productImage));
            }
        }
    }
}