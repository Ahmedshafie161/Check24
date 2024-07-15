package com.check.product.data.dataSource

import com.check.product.data.models.ProductResponseDataModel

interface ProductIDataSource {
    suspend fun getProductList(): Result<ProductResponseDataModel>
}