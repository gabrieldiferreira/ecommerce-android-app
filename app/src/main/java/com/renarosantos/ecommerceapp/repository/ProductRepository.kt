package com.renarosantos.ecommerceapp.repository

import com.renarosantos.ecommerceapp.data.model.ProductCardViewState
import com.renarosantos.ecommerceapp.data.remote.APIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProductRepository {

    private val client = APIClient().getClient()

    // preciso colocar aqui a logica para acessar a API
    suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            client.getProductList().map {
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