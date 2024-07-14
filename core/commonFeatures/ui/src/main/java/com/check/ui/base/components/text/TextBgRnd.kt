package com.check.ui.base.components.text

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.check.designsystem.theme.CustomTheme
import com.check.ui.base.components.shimmerBrush
import com.check.ui.base.extentions.conditional

@Composable
fun TextBgRnd(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = CustomTheme.typography.label_16,
    textColor: Color = CustomTheme.colors.White,
    textAlign: TextAlign = TextAlign.Center,
    spaceBetweenItems: Dp = 0.dp,
    spaceBetweenTextAndPostImg: Dp = spaceBetweenItems,
    backgroundColor: Color = CustomTheme.colors.DarkMintGreen.copy(.4f),
    @DrawableRes leadImgId: Int? = null,
    @DrawableRes postImgId: Int? = null,
    imageSize: Dp = 0.dp,
    horizontalPadding: Dp = 15.dp,
    isShimmerEnabled: () -> Boolean = { false },
    shimmerTimer: Int = 2000,
    tintColor: Color = Color.Unspecified
) {
    val showShimmer = rememberUpdatedState(newValue = isShimmerEnabled)
    Row(
        modifier = modifier
            .conditional(showShimmer.value(),
                {
                    shimmerBrush(
                        targetValue = 1300f,
                        showShimmer = { showShimmer.value() },
                        timer = shimmerTimer
                    )
                },
                { background(backgroundColor) })
            .padding(horizontal = horizontalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        leadImgId?.let {
            Icon(
                painter = painterResource(id = it),
                modifier = Modifier.size(imageSize),
                contentDescription = "",
                tint = tintColor
            )
            Spacer(modifier = Modifier.width(spaceBetweenTextAndPostImg))
        }
        Text(
            text = text,
            textAlign = textAlign,
            style = textStyle,
            color = textColor,
        )
        postImgId?.let { postImg ->
            Spacer(modifier = Modifier.width(spaceBetweenItems))
            Image(
                painter = painterResource(id = postImg),
                modifier = Modifier.size(imageSize),
                contentDescription = ""
            )
        }
    }
}
