package com.renarosantos.ecommerceapp.ui.productlist

import com.renarosantos.ecommerceapp.data.model.ProductCardViewState

sealed class ProductListViewState {
    //preciso de 3 estados para minha aplicacao
    //estado de Loading: Carregar a API
    //estado de Content: Conteudo a ser mostrado
    //estado de Error: Caso de erro na aplicacao

    object Loading: ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    object Error: ProductListViewState()

}