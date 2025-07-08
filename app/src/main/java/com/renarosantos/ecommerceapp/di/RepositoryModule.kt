package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.ProductRepository
import com.renarosantos.ecommerceapp.data.remote.APIClient
import com.renarosantos.ecommerceapp.data.remote.ProductService
import com.renarosantos.ecommerceapp.repository.ProductRepositoryAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesProductService(): ProductService = APIClient.getService()

    @Provides
    fun providesProductRepositoryAPI(
        service: ProductService
    ): ProductRepositoryAPI = ProductRepositoryAPI(service)


    @Provides
    fun providesProductRepository(
        productRepositoryAPI: ProductRepositoryAPI
    ): ProductRepository = productRepositoryAPI

}