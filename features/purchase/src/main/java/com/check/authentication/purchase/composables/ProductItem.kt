package com.check.authentication.purchase.composables

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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.check.authentication.purchase.models.ProductUiModel
import com.check.ui.base.components.RemoteImage
import com.check.ui.base.extentions.toFormattedDateString

@Composable
fun ProductItem(productUiModel: () -> ProductUiModel) {
    val updatedProductModel = rememberUpdatedState(newValue = productUiModel())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            RemoteImage(
                modifier = Modifier.size(60.dp),
                imageUrl = updatedProductModel.value.imageURL,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(updatedProductModel.value.name, fontWeight = FontWeight.Bold)
                    Text(
                        updatedProductModel.value.releaseDate.toFormattedDateString(),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Text(updatedProductModel.value.description)
                Text(
                    "Preis: ${updatedProductModel.value.priceUiModel.value} ${updatedProductModel.value.priceUiModel.currency}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Row {
                    val fullStarCounts = updatedProductModel.value.rating.toInt()
                    val halfStar = (updatedProductModel.value.rating - fullStarCounts >= 0.5f)
                    val emptyStarsCount = 5 - fullStarCounts - if (halfStar) 1 else 0
                    repeat(fullStarCounts) {
                        Icon(Icons.Filled.Star, contentDescription = "Full Star", tint = Color(0XFFFCD205))
                    }
                    if (halfStar) {
                        Icon(Icons.Filled.StarHalf, contentDescription = "Half Star", tint = Color(0XFFFCD205))
                    }
                    repeat(emptyStarsCount) {
                        Icon(Icons.Filled.StarBorder, contentDescription = "Empty Star", tint = Color(0XFFFCD205))
                    }
                }
            }
        }
    }
}
