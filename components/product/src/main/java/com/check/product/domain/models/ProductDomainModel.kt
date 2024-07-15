package com.check.product.domain.models

data class ProductDomainModel(
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
    val priceDataModel: PriceDomainModel
)

