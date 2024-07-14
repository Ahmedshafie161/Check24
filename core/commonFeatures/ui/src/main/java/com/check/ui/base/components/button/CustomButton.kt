package com.check.ui.base.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.check.designsystem.theme.CustomTheme

@Composable
fun CustomButton(
    modifier: Modifier = Modifier
        .padding(bottom = CustomTheme.sizing.small_xL)
        .width(CustomTheme.sizing.buttonWidth)
        .height(CustomTheme.sizing.small_x),
    onClick: () -> Unit = {},
    buttonColor: Color = CustomTheme.colors.LavaRed,
    textColor: Color = CustomTheme.colors.White,
    text: String,
    textStyle: TextStyle = CustomTheme.typography.label_16
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor
        ),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}
