package com.renarosantos.ecommerceapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {
    companion object {
        fun getService(): ProductService {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-android-course-api.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ProductService::class.java)
        }
    }
}