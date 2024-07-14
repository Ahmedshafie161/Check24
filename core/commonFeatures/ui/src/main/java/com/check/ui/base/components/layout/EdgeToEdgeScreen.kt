package com.check.ui.base.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.check.ui.base.edgeToEdge

@Composable
fun EdgeToEdgeScreen(
    screenBackground: Color,
    content: @Composable (modifier: Modifier) -> Unit
) {
    content(
        modifier = Modifier.edgeToEdge(LocalContext.current, screenBackground = screenBackground)
    )
}
