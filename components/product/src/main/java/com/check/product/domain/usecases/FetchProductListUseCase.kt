package com.check.product.domain.usecases

import com.check.product.domain.models.ProductListDomainModel
import com.check.product.domain.repositories.ProductIRepo
import javax.inject.Inject

class FetchProductListUseCase @Inject constructor(private val productIRepo: ProductIRepo){
    suspend  operator fun invoke(): Result<ProductListDomainModel> {
        return productIRepo.getProductList()
    }
}