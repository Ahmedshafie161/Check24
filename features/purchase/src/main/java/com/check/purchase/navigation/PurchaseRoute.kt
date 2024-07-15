package com.check.purchase.navigation;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.check.purchase.PurchaseViewModel
import com.check.purchase.composables.PurchaseScreen
import com.check.ui.base.sideEffect
import com.check.ui.base.viewState

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