package com.check.product.data.dataSource.remote

import com.check.network.RetrofitFactory
import com.check.product.data.dataSource.ProductIDataSource
import com.check.product.data.models.ProductResponseDataModel
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor() : ProductIDataSource {
    override suspend fun getProductList(): Result<ProductResponseDataModel> {
        return kotlin.runCatching {
            RetrofitFactory.create(apiService = ProductApiService::class.java).getResponseData()
                .let { response ->
                    response.body()?: throw IllegalArgumentException("Response body is null")
                }
        }
    }}
