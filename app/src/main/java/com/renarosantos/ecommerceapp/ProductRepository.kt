package com.renarosantos.ecommerceapp

import com.renarosantos.ecommerceapp.data.model.ProductCardViewState

interface ProductRepository {

    suspend fun getProductList() : List<ProductCardViewState>

}