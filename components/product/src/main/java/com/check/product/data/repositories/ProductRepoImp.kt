package com.check.product.data.repositories

import com.check.product.data.dataSource.ProductIDataSource
import com.check.product.data.models.toProductListDomainModel
import com.check.product.domain.models.ProductListDomainModel
import com.check.product.domain.repositories.ProductIRepo
import javax.inject.Inject

class ProductRepoImp @Inject constructor (private val productDataSource: ProductIDataSource):ProductIRepo{
    override suspend fun getProductList(): Result<ProductListDomainModel> {
        return productDataSource.getProductList().map { it.toProductListDomainModel() }
    }
}