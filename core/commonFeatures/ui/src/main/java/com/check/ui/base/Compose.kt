package com.check.ui.base

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat


@Stable
fun Modifier.statusBarTopPadding(
    screenBackground: Color = Color.Unspecified,
    statusBarBackGroundColor: Color = Color.Unspecified,
    statusBarIconBackGroundColor: Color = Color.Unspecified
): Modifier = composed {
    val context = LocalView.current.context as Activity
    if (statusBarBackGroundColor != Color.Unspecified || statusBarIconBackGroundColor != Color.Unspecified) {
        // status bar background color
        context.window.statusBarColor = statusBarBackGroundColor.toArgb()
        // status bar icon color
        val wic = WindowCompat.getInsetsController(context.window, context.window.decorView)
        wic.isAppearanceLightStatusBars = false
    }

    return@composed this
        .background(screenBackground)
        .padding(
            top = WindowInsets.statusBars
                .asPaddingValues()
                .calculateTopPadding()
        )
//        .safeContentPadding()
}
/*
fun Modifier.statusBarTopPadding(
    context: Activity,
    screenBackground: Color = Color.Unspecified,
    statusBarBackGroundColor: Color = Color.Unspecified,
    statusBarIconBackGroundColor: Color = Color.Unspecified
): Modifier {
    if (statusBarBackGroundColor != Color.Unspecified || statusBarIconBackGroundColor != Color.Unspecified) {
        // status bar background color
        context.window.statusBarColor = statusBarBackGroundColor.toArgb()
        // status bar icon color
        val wic = WindowCompat.getInsetsController(context.window, context.window.decorView)
        wic.isAppearanceLightStatusBars = false
    }

    return this
        .background(screenBackground)
        .padding(
            top = WindowInsets.statusBars
                .asPaddingValues()
                .calculateTopPadding()
        )
        .safeContentPadding()
}
*/

@Stable
fun Modifier.edgeToEdge(
    context: Context,
    screenBackground: Color = Color.Unspecified,
): Modifier {
    val activity = context as Activity
    activity.window.statusBarColor = Color.Unspecified.toArgb()
    return this.background(screenBackground)
}

@Composable
fun getScreenWidth() = LocalConfiguration.current.screenWidthDp.dp

@Stable
fun Modifier.statusBarBackgroundColor(
    statusBarBackGroundColor: Color = Color.Unspecified,
    statusBarIconBackGroundColor: Color = Color.Unspecified
): Modifier = composed {
    val context = LocalContext.current as Activity
    if (statusBarBackGroundColor != Color.Unspecified || statusBarIconBackGroundColor != Color.Unspecified) {
        // status bar background color
        context.window.statusBarColor = statusBarBackGroundColor.toArgb()
        // status bar icon color
        val wic = WindowCompat.getInsetsController(context.window, context.window.decorView)
        wic.isAppearanceLightStatusBars = false
    }
    return@composed this
}

@Stable
fun Modifier.statusBarCustomPadding(
): Modifier = composed {
    return@composed this
        .padding(
            top = WindowInsets.statusBars
                .asPaddingValues()
                .calculateTopPadding(),
        )
}