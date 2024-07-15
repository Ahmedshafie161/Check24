package com.check.purchase.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.check.authentication.R
import com.check.purchase.PurchaseContract
import com.check.designsystem.theme.CustomTheme

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
            title = { Text(stringResource(R.string.app_name), color = Color.White) },
            backgroundColor = CustomTheme.colors.lightBlue
        )
        FilterButtons { updatedState.value.productListUiModel.filters }
        ContentSection(
            modifier = Modifier.wrapContentHeight(),
            title = { updatedState.value.productListUiModel.headerUiModel.headerTitle },
            subTitle = { updatedState.value.productListUiModel.headerUiModel.headerDescription },
            productUiModelList = { updatedState.value.productListUiModel.productUiModels }
        )
        Spacer(modifier = Modifier.weight(1f))
        FooterText(modifier = Modifier)
    }
    if (updatedState.value.isLoading) {
        LoadingDialog()
    }
}

@Preview
@Composable
private fun TestAuthScreen() {
    PurchaseScreen(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        state = { mutableStateOf(PurchaseContract.State()) },
        onBackPressed = {},
        onEvent = {}
    )
}