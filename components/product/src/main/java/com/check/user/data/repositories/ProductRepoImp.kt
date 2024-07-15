package com.check.user.data.repositories

import com.check.user.data.dataSource.ProductIDataSource
import com.check.user.data.models.toProductListDomainModel
import com.check.user.domain.models.ProductListDomainModel
import com.check.user.domain.repositories.ProductIRepo
import javax.inject.Inject

class ProductRepoImp @Inject constructor (private val productDataSource: ProductIDataSource):ProductIRepo{
    override suspend fun getProductList(): ProductListDomainModel? {
        return productDataSource.getProductList()?.toProductListDomainModel()
    }
}