package com.check.purchaseProductList.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.check.designsystem.theme.CustomTheme
import com.check.purchaseProductList.models.ProductUiModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun ContentSection(
    modifier: Modifier = Modifier,
    title: () -> String,
    subTitle: () -> String,
    productUiModelList: () -> ImmutableList<ProductUiModel>
) {
    Column(modifier = modifier.padding(CustomTheme.sizing.x)) {
        Text(title(), style = CustomTheme.typography.label_18_bold)
        Text(subTitle(), style = CustomTheme.typography.label_16, color = Color.Gray)

        Spacer(modifier = Modifier.height(CustomTheme.sizing.x))

        LazyColumn(Modifier.heightIn(max = 650.dp)) {
            items(productUiModelList(), key = { it.id }) { ProductItem { it } }
        }
    }
}