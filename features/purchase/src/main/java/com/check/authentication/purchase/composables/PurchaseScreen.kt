package com.check.authentication.purchase.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.check.authentication.purchase.PurchaseContract

@Composable
internal fun PurchaseScreen(
    modifier: Modifier,
    onEvent: (PurchaseContract.Event) -> Unit,
    state: () -> State<PurchaseContract.State>,
    onBackPressed: () -> Unit
) {
    Column (modifier = modifier){
     LazyColumn {
         items(state().value.productListUiModel.productUiModels){
             Text("${it.id}")
         }
     }
    }
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