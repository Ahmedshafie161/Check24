package com.check.ui.base.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ScreenWidthProvider(content: @Composable (screenSizePx: Float) -> Unit) {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current

    val screenSizePx = remember(density, configuration) {
        density.run { configuration.screenWidthDp.dp.toPx() }
    }

    content(screenSizePx)
}
