package com.check.ui.base.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.check.designsystem.theme.CustomTheme
import com.check.ui.base.extentions.safeClickable

@Composable
fun ButtonImage(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    bngColor: Color = Color.Unspecified,
    @DrawableRes imageResource: Int,
) {
    Box(
        modifier = modifier
            .background(bngColor)
            .safeClickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Icon(
            painterResource(id = imageResource),
            contentDescription = "",
            tint = CustomTheme.colors.White
        )
    }
}
