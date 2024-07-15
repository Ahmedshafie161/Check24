package com.check.authentication.purchase.models

data class ProductListUiModel(
    val headerUiModel: HeaderUiModel,
    val filters: List<String>,
    val productUiModels: List<ProductUiModel>
)