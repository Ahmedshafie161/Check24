package com.check.ui.base.components.layout

import android.app.Activity
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat

@Composable
private fun HandleSystemBarsColor(
    view: View,
    darkTheme: Boolean,
    statusBarColor: Int = android.graphics.Color.TRANSPARENT,
    navigationBarColor: Int = android.graphics.Color.BLACK
) {
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = statusBarColor
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            window.navigationBarColor = android.graphics.Color.BLACK
        }
    }
}
