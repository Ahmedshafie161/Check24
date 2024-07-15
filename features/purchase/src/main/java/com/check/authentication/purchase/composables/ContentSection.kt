package com.check.authentication.purchase.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.check.authentication.purchase.models.ProductUiModel
import kotlinx.collections.immutable.ImmutableList

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
