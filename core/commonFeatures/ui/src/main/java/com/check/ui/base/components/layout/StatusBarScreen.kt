package com.check.ui.base.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.lang.reflect.Modifier


@Composable
inline fun StatusBarScreen(
    screenBackground: Color,
    statusBarBackGroundColor: Color,
    content: @Composable (modifier: Modifier) -> Unit
) {
/*
    content(
        modifier = Modifier.statusBarTopPadding(
            screenBackground = screenBackground,
            statusBarBackGroundColor = statusBarBackGroundColor
        )
    )
*/
}
