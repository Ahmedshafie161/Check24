package com.check.purchase.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.check.authentication.R
import com.check.designsystem.theme.CustomTheme
import com.check.purchase.models.ProductUiModel
import com.check.ui.base.components.RemoteImage
import com.check.ui.base.extentions.toFormattedDateString

@Composable
fun ProductItem(productUiModel: () -> ProductUiModel) {
    val updatedProductModel = rememberUpdatedState(newValue = productUiModel())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = CustomTheme.sizing.small_xL),
        shape = RoundedCornerShape(CustomTheme.sizing.small_xL),
        elevation = CustomTheme.sizing.small
    ) {
        Row(modifier = Modifier.padding(CustomTheme.sizing.x)) {
            if (updatedProductModel.value.available) {
                RemoteImage(
                    modifier = Modifier.size(CustomTheme.sizing.medium),
                    imageUrl = updatedProductModel.value.imageURL,
                )
                Spacer(modifier = Modifier.width(CustomTheme.sizing.x))
            }
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(updatedProductModel.value.name, fontWeight = FontWeight.Bold)
                    if (updatedProductModel.value.available) {
                        Text(
                            updatedProductModel.value.releaseDate.toFormattedDateString(),
                            style = CustomTheme.typography.label_12_req,
                            color = Color.Gray
                        )
                    }
                }
                Text(updatedProductModel.value.description)
                if (updatedProductModel.value.available) {
                    Text(
                        stringResource(
                            id = R.string.purchase_product_price,
                            updatedProductModel.value.priceUiModel.value,
                            updatedProductModel.value.priceUiModel.currency
                        ),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                RatingStars(updatedProductModel)
            }
            if (updatedProductModel.value.available.not()) {
                RemoteImage(
                    modifier = Modifier.size(CustomTheme.sizing.medium),
                    imageUrl = updatedProductModel.value.imageURL,
                )
            }
        }
    }
}

@Composable
private fun RatingStars(updatedProductModel: State<ProductUiModel>) {
    Row {
        val fullStarCounts =
            remember { mutableIntStateOf(updatedProductModel.value.rating.toInt()) }
        val halfStar = remember {
            mutableStateOf((updatedProductModel.value.rating - fullStarCounts.intValue >= 0.5f))
        }
        val emptyStarsCount =
            MAX_STAR_COUNT - fullStarCounts.intValue - if (halfStar.value) 1 else 0
        repeat(fullStarCounts.intValue) {
            Icon(
                Icons.Filled.Star,
                contentDescription = null,
                tint = CustomTheme.colors.gold
            )
        }
        if (halfStar.value) {
            Icon(
                Icons.Filled.StarHalf,
                contentDescription = null,
                tint = CustomTheme.colors.gold
            )
        }
        repeat(emptyStarsCount) {
            Icon(
                Icons.Filled.StarBorder,
                contentDescription = null,
                tint = CustomTheme.colors.gold
            )
        }
    }
}

const val MAX_STAR_COUNT = 5