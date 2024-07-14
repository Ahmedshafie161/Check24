package com.check.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AbsSizing(
    val default: Dp = 0.dp,

    // normalized //TODO AGREE ON THE NAMING
    val half: Dp = .5.dp,
    val unit: Dp = 1.dp,
    val x_small: Dp = 11.3.dp,
    val small: Dp = 24.dp,
    val small_x: Dp = 34.5.dp,
    val medium: Dp = 28.dp,
    val patrolCardHeightMissionDetails: Dp = 200.dp,
    val patrolCardHeightLogbook: Dp = 134.dp,
    val buttonWidth: Dp = 161.dp,
    val cardWidth :Dp = 124.5.dp,
    val cardHeight :Dp = 221.5.dp,
    val small_xL :Dp = 8.dp,
    val small_xxL :Dp = 20.dp,
)

val LocalAbsSizing = staticCompositionLocalOf { AbsSizing() }
