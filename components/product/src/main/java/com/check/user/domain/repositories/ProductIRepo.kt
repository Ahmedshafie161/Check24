package com.check.user.domain.repositories

import com.check.user.domain.models.ProductListDomainModel

interface ProductIRepo {
    suspend fun getProductList(): ProductListDomainModel?
}