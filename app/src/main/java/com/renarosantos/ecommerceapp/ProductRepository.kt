package com.renarosantos.ecommerceapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProductRepository {

    // preciso colocar aqui a logica para acessar a API
    suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            delay(3000)
            (1..3).map {
                ProductCardViewState(
                    "Playstation $it",
                    "This is a nice console! Check it out",
                    "200 US$"
                )
            }
        }
    }
}
