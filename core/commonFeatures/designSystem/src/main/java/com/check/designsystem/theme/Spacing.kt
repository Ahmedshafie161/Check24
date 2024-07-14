package com.check.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AbsSpacing(
    val default: Dp = 0.dp,

    val unit: Dp = 1.dp,
    val extra_xxs: Dp = 2.dp,
    val xxs: Dp = 4.dp,
    val xs: Dp = 9.dp,
    val s: Dp = 12.5.dp,
    val m: Dp = 16.dp,
    val l: Dp = 26.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 48.dp,
    val padding: Dp = 8.dp,
    val primaryPadding: Dp = 18.dp,
    val paddingLarge: Dp = xl,
    val paddingLargeExtra: Dp = 40.dp,
    val rowSpacing: Dp = 20.5.dp,
    val spacerMax: Dp = 148.dp,
    val spacerXXL: Dp = xxl,
    val spacerXL: Dp = xl,
    val spacerL: Dp = 22.5.dp,
    val spacer: Dp = 15.dp,
    val spacerM: Dp = 20.dp,
    val spacerMini: Dp = 10.dp,
    val cardPadding: Dp = s,
    val briefingIconsDimen: Dp = 72.dp,
    val imageHeight: Dp = 418.dp,
    val xSpace: Dp = 37.5.dp,
    val xSxpace: Dp = 26.dp,
    val xxSxpace: Dp = 14.dp

)

val LocalAbsSpacing = staticCompositionLocalOf { AbsSpacing() }
