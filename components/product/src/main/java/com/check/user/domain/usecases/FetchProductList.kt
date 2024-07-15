package com.check.user.domain.usecases

import com.check.user.domain.models.ProductListDomainModel
import com.check.user.domain.repositories.ProductIRepo
import javax.inject.Inject

class FetchProductList @Inject constructor(private val productIRepo: ProductIRepo){
    suspend  operator fun invoke(): ProductListDomainModel? {
        return productIRepo.getProductList()
    }
}