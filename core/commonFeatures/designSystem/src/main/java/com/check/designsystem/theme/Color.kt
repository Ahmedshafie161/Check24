package com.check.designsystem.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

object AbsColor {
    val White: Color = Color(0xffffffff)
    val Black: Color = Color(0xFF000000)
    val DarkGrey: Color = Color(0xFF242222)
    val MediumGrey: Color = Color(0xb37b7b7b)
    val LavaRed: Color = Color(0xFFED202D)
    val LightRed: Color = Color(0xFFfb0202)
    val DarkMintGreen: Color = Color(0xFF13bf74)
    val lightGreen: Color = Color(0xff07f77e)
    val lightGrayy: Color = Color(0X99ffffff)
    val lightBlue: Color = Color(0XFF035EA8)
    val gold: Color = Color(0XFFFCD205)

}

val LocalAbsColor = compositionLocalOf { AbsColor }
