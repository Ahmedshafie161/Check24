package com.check.user.data.dataSource

import com.check.user.data.models.ProductResponseDataModel

interface ProductIDataSource {
    suspend fun getProductList (): ProductResponseDataModel?
}