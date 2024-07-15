package com.check.product.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductDataModel(
    val name: String,
    val type: String,
    val id: Int,
    val color: String,
    val imageURL: String,
    val colorCode: String,
    val available: Boolean,
    val releaseDate: Long,
    val description: String,
    val longDescription: String,
    val rating: Double,
    @SerializedName("price")
    val priceDataModel: PriceDataModel
)

