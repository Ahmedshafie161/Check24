package com.check.purchaseProductList.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.check.authentication.R
import com.check.designsystem.theme.CustomTheme

@Composable
fun FooterText(modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.purchase_footer_trade_mark),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(CustomTheme.sizing.x),
        textAlign = TextAlign.Start,
        color = Color.Black
    )
}
