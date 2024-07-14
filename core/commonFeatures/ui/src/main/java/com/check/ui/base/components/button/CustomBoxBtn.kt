package com.check.ui.base.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.check.designsystem.theme.CustomTheme
import com.check.ui.base.components.LogComposable
import com.check.ui.base.components.shimmerBrush
import com.check.ui.base.extentions.conditional
import com.check.ui.base.extentions.debounceClickable

@Composable
fun CustomBoxBtn(
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),
    text: String,
    textColor: Color,
    bngColor: Color,
    bndDisableColor: Color = bngColor,
    isBtnEnabled:() ->Boolean = { true },
    width: Dp,
    height: Dp = width,
    textStyle: TextStyle,
    isShimmerEnabled: () -> Boolean = { false },
    shape: Shape = RoundedCornerShape(50),
    @DrawableRes postImgId: Int? = null,
    @DrawableRes leadingImgId: Int? = null,
    postImgColor: Color = CustomTheme.colors.White,
    leadingImgColor: Color = CustomTheme.colors.White,
    onClick: () -> Unit
) {
    val showShimmer = rememberUpdatedState(newValue = isShimmerEnabled)
    val isEnabledState = rememberUpdatedState(newValue = isBtnEnabled)
    val textColorState = remember { mutableStateOf(textColor) }
    val widthState = remember { mutableStateOf(width) }
    val heightState = remember { mutableStateOf(height) }

    LogComposable(msg = "isEnabled: ${isEnabledState.value()} ,bngColor${bngColor.value} ,bndDisableColor ${bndDisableColor.value}")
    Box(
        modifier = modifier
            .size(widthState.value, heightState.value)
            .clip(shape)
            .conditional(isEnabledState.value(), { background(bngColor) }, { background(bndDisableColor) })
            .conditional(showShimmer.value(), { shimmerBrush({ showShimmer.value() }, width.value) })
            .conditional(isEnabledState.value(), { debounceClickable { onClick() } })
            .padding(contentPaddingValues),
    ) {
        leadingImgId?.let {
            Icon(
                imageVector = ImageVector.vectorResource(id = leadingImgId ),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterStart),
                tint = leadingImgColor
            )
        }
        Text(
            text = text,
            color = textColorState.value,
            style = textStyle,
            modifier = Modifier.align(Alignment.Center)
        )
        postImgId?.let {
            Icon(
                imageVector = ImageVector.vectorResource(id = postImgId ),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterEnd),
                tint = postImgColor
            )
        }
    }
}
