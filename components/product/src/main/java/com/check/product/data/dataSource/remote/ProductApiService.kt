package com.check.product.data.dataSource.remote

import com.check.product.data.models.ProductResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    companion object{
        const val PRODUCT_LIST_END_POINT = "products-test.json"
    }
    @GET(PRODUCT_LIST_END_POINT)
    suspend fun getResponseData(): Response<ProductResponseDataModel>
}