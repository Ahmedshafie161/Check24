package com.check.user.data.models

import com.check.user.domain.models.HeaderDomainModel
import com.check.user.domain.models.PriceDomainModel
import com.check.user.domain.models.ProductDomainModel
import com.check.user.domain.models.ProductListDomainModel

internal fun ProductResponseDataModel.toProductListDomainModel() = ProductListDomainModel(
    headerDomainModel = this.headerDataModel.toHeaderDomainModel(),
    filters = this.filters,
    productDomainModels = this.productDataModels.map { it.toProductDomainModel() }
)

internal fun ProductDataModel.toProductDomainModel() = ProductDomainModel(
    name = this.name,
    type = this.type,
    id = this.id,
    color = this.color,
    imageURL = this.imageURL,
    colorCode = this.colorCode,
    available = this.available,
    releaseDate = this.releaseDate,
    description = this.description,
    longDescription = this.longDescription,
    rating = this.rating,
    priceDataModel = this.priceDataModel.toPriceDomainModel()
)
internal fun PriceDataModel.toPriceDomainModel() = PriceDomainModel(
    value = this.value,
    currency= this.currency
)
internal fun HeaderDataModel.toHeaderDomainModel() = HeaderDomainModel(
    headerTitle = this.headerTitle,
    headerDescription = this.headerDescription
)