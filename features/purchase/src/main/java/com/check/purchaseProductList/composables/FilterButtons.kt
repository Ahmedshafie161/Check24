package com.check.purchaseProductList.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.ImmutableList

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
