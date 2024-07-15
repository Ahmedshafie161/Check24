package com.check.purchase.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.check.authentication.R
import com.check.designsystem.theme.CustomTheme
import com.check.purchase.PurchaseContract
import com.check.purchase.PurchaseState

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PurchaseScreen(
    modifier: Modifier,
    onEvent: (PurchaseContract.Event) -> Unit,
    state: () -> State<PurchaseContract.State>,
    onBackPressed: () -> Unit
) {
    val pullRefreshState = rememberPullRefreshState(state().value.isRefreshing, { onEvent(PurchaseContract.Event.Refresh) })
    val updatedState = rememberUpdatedState(newValue = state().value.purchaseState)
    when (val purchaseState = updatedState.value) {
        PurchaseState.Error -> ErrorPopup({ onEvent(PurchaseContract.Event.OnDismissAlertDialog) })
        PurchaseState.Loading -> LoadingDialog()
        is PurchaseState.Data -> {
            Column(modifier = modifier.pullRefresh(pullRefreshState)) {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name), color = Color.White) },
                    backgroundColor = CustomTheme.colors.lightBlue
                )
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
