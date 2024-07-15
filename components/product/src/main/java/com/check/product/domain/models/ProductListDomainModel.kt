package com.check.product.domain.models

data class ProductListDomainModel(
    val headerDomainModel: HeaderDomainModel,
    val filters: List<String>,
    val productDomainModels: List<ProductDomainModel>
)