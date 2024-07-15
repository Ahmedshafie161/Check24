package com.check.product.domain.repositories

import com.check.product.domain.models.ProductListDomainModel

interface ProductIRepo {
    suspend fun getProductList(): Result<ProductListDomainModel>
}