package com.renarosantos.ecommerceapp.ui.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository : ProductRepository
): ViewModel() {

    private val _viewState = MutableLiveData<ProductListViewState>()
    val viewState: LiveData<ProductListViewState>
        get() = _viewState

    fun loadProductList() {
        viewModelScope.launch {
            _viewState.postValue(ProductListViewState.Loading)
            val productList = repository.getProductList()
            _viewState.postValue(ProductListViewState.Content(productList))
        }
    }
}