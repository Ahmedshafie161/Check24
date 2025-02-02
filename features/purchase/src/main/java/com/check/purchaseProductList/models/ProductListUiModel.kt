package com.check.purchaseProductList.models

import kotlinx.collections.immutable.ImmutableList

data class ProductListUiModel(
    val headerUiModel: HeaderUiModel,
    val filters: ImmutableList<String>,
    val productUiModels: ImmutableList<ProductUiModel>
)