package com.check.purchaseProductList.navigation;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.check.purchaseProductList.PurchaseViewModel
import com.check.purchaseProductList.composables.PurchaseScreen
import com.check.ui.base.sideEffect
import com.check.ui.base.viewState

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PurchaseRoute(
    modifier: Modifier = Modifier,
    viewModel: PurchaseViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    onAccountCreated: () -> Unit,
) {
    viewModel.init()
    val state = viewModel.viewState()

    PurchaseScreen(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        onEvent = { viewModel.handleEvents(it) },
        state = { state },
        onBackPressed = onBackPressed
    )
    viewModel.sideEffect { effect ->
        when (effect) {
            else -> {}
        }
    }
}