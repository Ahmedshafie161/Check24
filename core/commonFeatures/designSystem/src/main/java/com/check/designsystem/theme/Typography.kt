package com.check.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.check.core.commonFeatures.designsystem.R

object FontSize {
    val xSmall = 8.8.sp
    val small = 8.sp
}

data class CustomTypography(
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    val titleLarge: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    val labelSmall: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 19.sp,
        letterSpacing = 0.sp,
    ),
    val labelXSmall: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 9.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_14: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_14_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_14_5_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.5.sp,
        lineHeight = 16.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_15: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 16.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_15_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 16.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_16: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_book)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    )   ,
    val label_16_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),
    val label_17_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp,
    ),
    val label_17: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp,
    ),
    val label_13: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 9.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_13_med: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 9.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_11: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 9.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_18: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 19.7.sp,
        letterSpacing = 0.sp,
    ),
    val label_18_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.3.sp,
        lineHeight = 19.7.sp,
        letterSpacing = 0.sp,
    ),
    val label_18_bold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.3.sp,
        lineHeight = 19.7.sp,
        letterSpacing = 0.sp,
    ),
    val label_24: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),
    val label_24_bold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 27.5.sp,
        letterSpacing = 0.sp,
    ),
    val label_10: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),
    val label_12_medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 9.sp,
        letterSpacing = 0.sp,
    ),
    val label_12_req: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 9.sp,
        letterSpacing = 0.sp,
    ),
    val label_21: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.avenir_lt_pro_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    )

)

val LocalAbsTypography = staticCompositionLocalOf { CustomTypography() }

