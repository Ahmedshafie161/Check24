package com.check.ui.base.components.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.check.designsystem.theme.CustomTheme

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    textAlign: TextAlign,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val customTheme = CustomTheme
    Text(
        text = text,
        textAlign = textAlign,
        style = if (isSelected) customTheme.typography.label_15_medium else customTheme.typography.label_15,
        color = if (isSelected) customTheme.colors.White else customTheme.colors.lightGrayy,
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            onClick()
        },
    )
}
