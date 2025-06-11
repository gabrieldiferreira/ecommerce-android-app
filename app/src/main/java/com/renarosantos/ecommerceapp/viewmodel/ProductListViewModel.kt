package com.renarosantos.ecommerceapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.viewmodel.ProductListViewState
import com.renarosantos.ecommerceapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val _viewState = MutableLiveData<ProductListViewState>()
    val viewState: LiveData<ProductListViewState>
        get() = _viewState

    private val repository = ProductRepository()

    fun loadProductList() {
        viewModelScope.launch {
            _viewState.postValue(ProductListViewState.Loading)
            val productList = repository.getProductList()
            _viewState.postValue(ProductListViewState.Content(productList))
        }
    }
}