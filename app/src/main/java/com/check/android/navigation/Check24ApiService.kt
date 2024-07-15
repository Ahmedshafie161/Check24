package com.check.android.navigation

import com.check.product.data.models.ProductResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface  Check24ApiService{
    @GET("products-test.json")
    suspend fun getProducts(): Response<ProductResponseDataModel>
}