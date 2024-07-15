package com.check.user.data.dataSource.remote

import com.check.user.data.models.ProductResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    companion object{
        const val PRODUCT_LIST_END_POINT = "products-test.json"
    }
    @GET(PRODUCT_LIST_END_POINT)
    fun getResponseData(): Response<ProductResponseDataModel>
}