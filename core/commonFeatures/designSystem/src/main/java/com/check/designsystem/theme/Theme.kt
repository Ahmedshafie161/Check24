package com.check.designsystem.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.check.designsystem.theme.AbsColor.Black
import com.check.designsystem.theme.AbsColor.DarkGrey
import com.check.designsystem.theme.AbsColor.LavaRed
import com.check.designsystem.theme.AbsColor.White

private val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = White,
    tertiary = DarkGrey,
    background = Black,
)

private val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = White,
    tertiary = DarkGrey,
    background = Black,
    surface = DarkGrey,
    onPrimary = LavaRed,
    onSecondary = DarkGrey,
    onTertiary = White,
    onBackground = DarkGrey,
    onSurface = DarkGrey,
)

object CustomTheme {
    val colors
        @Composable
        @ReadOnlyComposable
        get() = LocalAbsColor.current

    val sizing
        @Composable
        @ReadOnlyComposable
        get() = LocalAbsSizing.current

    val spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalAbsSpacing.current
    val typography
        @Composable
        @ReadOnlyComposable
        get() = LocalAbsTypography.current
    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalAbsShape.current
}


@Composable
fun CheckTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    // handle status & system nav bar colors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.TRANSPARENT
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//            window.navigationBarColor = Color.TRANSPARENT
//            window.navigationBarColor = getColor(R.color.internal_black_semitransparent_light)
            enableTransparentNavigationBar(window)
        }
        CompositionLocalProvider(
            LocalAbsSpacing provides AbsSpacing(),
            LocalAbsSizing provides AbsSizing(),
            LocalAbsColor provides AbsColor,
            LocalAbsTypography provides CustomTypography(),
            LocalAbsShape provides Shapes,
        ) {
            content()
        }
    }
}

private fun enableTransparentNavigationBar(window: Window) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        window.navigationBarColor = Color.TRANSPARENT
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}

private fun hideNavigationBar(window: Window) {
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
        window.decorView.windowInsetsController?.let {
            it.hide(WindowInsets.Type.navigationBars())
        }
    } else {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
}