package com.check.user.data.models

import androidx.annotation.Keep

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
    val priceDataModel: PriceDataModel
)

