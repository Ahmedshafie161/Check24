package com.check.authentication.purchase.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.check.authentication.purchase.PurchaseContract
import com.check.authentication.purchase.models.ProductUiModel
import com.check.ui.base.components.RemoteImage
import com.check.ui.base.extentions.toFormattedDateString
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun PurchaseScreen(
    modifier: Modifier,
    onEvent: (PurchaseContract.Event) -> Unit,
    state: () -> State<PurchaseContract.State>,
    onBackPressed: () -> Unit
) {
    val updatedState = rememberUpdatedState(newValue = state().value)
    Column(modifier = modifier) {
        TopAppBar(
            title = {
                Text(
                    "Check24",
                    color = Color.White
                )
            },
            backgroundColor = Color(0XFF035EA8)
        )
        FilterButtons { updatedState.value.productListUiModel.filters }
        ContentSection(
            title = { updatedState.value.productListUiModel.headerUiModel.headerTitle },
            subTitle = { updatedState.value.productListUiModel.headerUiModel.headerDescription },
            productUiModelList = { updatedState.value.productListUiModel.productUiModels }
        )
        FooterText()
    }
    if (updatedState.value.isLoading) {
        LoadingDialog()
    }
}
@Composable
fun LoadingDialog() {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
@Composable
fun FilterButtons(filtersList: () -> ImmutableList<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(filtersList()) {
            TextButton(onClick = { /*TODO*/ }) { Text(it, color = Color.White) }
        }
    }
}

@Composable
fun ContentSection(
    title: () -> String,
    subTitle: () -> String,
    productUiModelList: () -> ImmutableList<ProductUiModel>
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(title(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(subTitle(), fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(productUiModelList()) { ProductItem { it } }
        }
    }
}

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

@Composable
fun FooterText() {
    Text(
        "Footer text..",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}


@Preview
@Composable
private fun TestAuthScreen() {
    PurchaseScreen(
        Modifier
            .fillMaxSize()
            .background(Color.Black),
        state = { mutableStateOf(PurchaseContract.State()) },
        onBackPressed = {},
        onEvent = {}
    )
}