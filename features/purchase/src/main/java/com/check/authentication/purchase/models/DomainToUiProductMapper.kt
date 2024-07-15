package com.check.authentication.purchase.models

import com.check.product.domain.models.HeaderDomainModel
import com.check.product.domain.models.PriceDomainModel
import com.check.product.domain.models.ProductDomainModel
import com.check.product.domain.models.ProductListDomainModel

internal fun ProductListDomainModel.toProductListUiModel() = ProductListUiModel(
    headerUiModel = this.headerDomainModel.toHeaderUiModel(),
    filters = this.filters,
    productUiModels = this.productDomainModels.map { it.toProductUiModel() }
)

internal fun ProductDomainModel.toProductUiModel() = ProductUiModel(
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
    priceDataModel = this.priceDataModel.toPriceUiModel()
)

internal fun PriceDomainModel.toPriceUiModel() = PriceUiModel(
    value = this.value,
    currency = this.currency
)

internal fun HeaderDomainModel.toHeaderUiModel() = HeaderUiModel(
    headerTitle = this.headerTitle,
    headerDescription = this.headerDescription
)