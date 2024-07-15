package com.check.user.data.models

import androidx.annotation.Keep

@Keep
data class ProductResponseDataModel(
    val headerDataModel: HeaderDataModel,
    val filters: List<String>,
    val productDataModels: List<ProductDataModel>
)