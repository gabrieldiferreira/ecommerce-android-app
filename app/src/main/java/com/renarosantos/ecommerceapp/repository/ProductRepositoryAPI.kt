package com.renarosantos.ecommerceapp.repository

import com.renarosantos.ecommerceapp.ProductRepository
import com.renarosantos.ecommerceapp.data.model.ProductCardViewState
import com.renarosantos.ecommerceapp.data.remote.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryAPI @Inject constructor(private val service: ProductService) : ProductRepository {

    // preciso colocar aqui a logica para acessar a API
    override suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            service.getProductList().map {
                ProductCardViewState(
                    it.title,
                    it.description,
                    "US $ ${it.price}",
                    it.imageUrl
                )
            }
        }
    }
}