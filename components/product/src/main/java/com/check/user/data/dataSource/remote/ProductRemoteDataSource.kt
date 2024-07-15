package com.check.user.data.dataSource.remote

import com.check.network.RetrofitFactory
import com.check.user.data.dataSource.ProductIDataSource
import com.check.user.data.models.ProductResponseDataModel
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor() : ProductIDataSource {
    override suspend fun getProductList(): ProductResponseDataModel? {
        try {
            val result =
                RetrofitFactory.create(apiService = ProductApiService::class.java).getResponseData()
            return result.body()
        } catch (e: Exception) {
            return null
        }
    }
}
