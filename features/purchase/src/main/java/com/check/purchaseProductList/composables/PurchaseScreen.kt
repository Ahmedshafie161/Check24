package com.check.purchaseProductList.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.check.authentication.R
import com.check.designsystem.theme.CustomTheme
import com.check.purchaseProductList.PurchaseContract
import com.check.purchaseProductList.PurchaseState

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PurchaseScreen(
    modifier: Modifier,
    onEvent: (PurchaseContract.Event) -> Unit,
    state: () -> State<PurchaseContract.State>,
    onBackPressed: () -> Unit
) {
    val updatedState = rememberUpdatedState(newValue = state().value)
    val isRefreshing = remember { derivedStateOf { updatedState.value.isRefreshing } }
    val pullRefreshState = rememberPullRefreshState(isRefreshing.value, { onEvent(PurchaseContract.Event.Refresh) })
    val updatedProductState = rememberUpdatedState(newValue = updatedState.value.purchaseState)

    when (val purchaseState = updatedProductState.value) {
        PurchaseState.Error -> ErrorPopup({ onEvent(PurchaseContract.Event.OnDismissAlertDialog) })
        PurchaseState.Loading -> LoadingDialog()
        is PurchaseState.Data -> {
            Column(modifier = modifier.pullRefresh(pullRefreshState)) {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name), color = Color.White) },
                    backgroundColor = CustomTheme.colors.lightBlue
                )
                Row(){
                    PullRefreshIndicator(
                        refreshing = isRefreshing.value,
                        state = pullRefreshState,
                        modifier = Modifier.align(Alignment.CenterVertically).weight(1f)
                    )
                }

                FilterButtons { purchaseState.productListUiModel.filters }
                ContentSection(
                    modifier = Modifier.wrapContentHeight(),
                    title = { purchaseState.productListUiModel.headerUiModel.headerTitle },
                    subTitle = { purchaseState.productListUiModel.headerUiModel.headerDescription },
                    productUiModelList = { purchaseState.productListUiModel.productUiModels }
                )
                Spacer(modifier = Modifier.weight(1f))
                FooterText(modifier = Modifier)
            }

        }
    }
}

/*
@Preview
@Composable
private fun TestAuthScreen() {
    PurchaseScreen(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        state = { mutableStateOf(PurchaseContract.State()) },
        onBackPressed = {},
        pullRefreshState = {PurchaseState()},
        onEvent = {}
    )
}*/
