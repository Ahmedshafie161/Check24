package com.check.product.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductResponseDataModel(
    @SerializedName("header")
    val headerDataModel: HeaderDataModel,
    @SerializedName("filters")
    val filters: List<String>,
    @SerializedName("products")
    val productDataModels: List<ProductDataModel>
)