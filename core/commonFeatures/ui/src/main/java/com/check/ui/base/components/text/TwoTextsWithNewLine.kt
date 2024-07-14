package com.check.ui.base.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import com.check.designsystem.theme.CustomTheme

@Composable
fun TwoTextsWithNewLine(
    firstText: String,
    firstFontFamily: FontFamily,
    firstSize: TextUnit,
    firstColor: Color = CustomTheme.colors.White,
    secondText: String,
    secondSize: TextUnit,
    secondColorCondition: Boolean = false,
    secondColorTrue: Color = CustomTheme.colors.lightGreen,
    secondColorDefault: Color = CustomTheme.colors.LightRed,
    secondFontFamily: FontFamily = firstFontFamily,
    appendMiddleText: String? = "\n"
) =
    buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = firstFontFamily,
                fontSize = firstSize,
                color = firstColor
            )
        ) {
            append(firstText)
        }
        append(appendMiddleText)
        withStyle(
            style = SpanStyle(
                color = if (secondColorCondition) secondColorTrue else secondColorDefault,
                fontFamily = secondFontFamily,
                fontSize = secondSize
            )
        ) {
            append(secondText)
        }
    }
