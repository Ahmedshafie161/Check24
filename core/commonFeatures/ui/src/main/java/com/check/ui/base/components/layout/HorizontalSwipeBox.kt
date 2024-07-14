package com.check.ui.base.components.layout

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.snapTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.check.core.commonFeatures.ui.R
import com.check.designsystem.theme.CustomTheme
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

data class SwipeInfo(
    val text: String = "",
    val color: Color = Color.Unspecified,
    @DrawableRes val icImg: Int? = null,
    val offsetVal: IntOffset? = null
)


enum class DragAnchors {
    Start,
    Center,
    End,
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalSwipeBox(
    modifier: Modifier = Modifier.fillMaxSize(),
    leftColor: Color = Color.Green,
    @DrawableRes leftImg: Int = R.drawable.ic_girl,
    rightColor: Color = Color.Red,
    @DrawableRes rightImg: Int = R.drawable.ic_cookie,
    imgSize: Dp = 200.dp,
    imgColor: Color = CustomTheme.colors.White,
    onScrolledToLeft: suspend () -> Unit = {},
    onScrolledToRight: suspend () -> Unit = {},
    leftText: String = "ali",
    rightText: String = "omar",
    textStyle: TextStyle? = null,
    textColor: Color = CustomTheme.colors.White,
    positionThresholdPercent: Float = 0.35f,
    velocityThresholdPercent: Float = Float.MAX_VALUE,
    content: @Composable BoxScope.() -> Unit = {},
) {
    val screenSizePx =
        with(LocalDensity.current) { LocalConfiguration.current.screenWidthDp.dp.toPx() }
    val draggableState = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Center,
            anchors = DraggableAnchors {
                DragAnchors.Start at screenSizePx
                DragAnchors.Center at 0f
                DragAnchors.End at -screenSizePx
            },
            positionalThreshold = { distance: Float -> distance * positionThresholdPercent },
            velocityThreshold = { velocityThresholdPercent },
            animationSpec = tween(),
        )
    }

    // update state depend on swipe direction
    val swipeInfo = remember {
        derivedStateOf {
            val currentOffset = draggableState.offset
            when {
                currentOffset > 0 -> SwipeInfo(
                    rightText,
                    rightColor,
                    rightImg,
                    IntOffset((currentOffset - screenSizePx).roundToInt(), 0)
                )

                currentOffset < 0 -> SwipeInfo(
                    leftText,
                    leftColor,
                    leftImg,
                    IntOffset((currentOffset + screenSizePx).roundToInt(), 0)
                )

                else -> SwipeInfo()
            }
        }
    }


    LaunchedEffect(draggableState.currentValue) {
        // need delay before snap so when scroll happens it wont lock in middle
        if (draggableState.currentValue == DragAnchors.Start) {
            onScrolledToRight()
            delay(250)
            draggableState.snapTo(DragAnchors.Center)
        } else if (draggableState.currentValue == DragAnchors.End) {
            onScrolledToLeft()
            delay(250)
            draggableState.snapTo(DragAnchors.Center)
        }
    }
    LaunchedEffect(draggableState.currentValue) {

    }
    Box(
        modifier = modifier
            .anchoredDraggable(
                state = draggableState,
                orientation = Orientation.Horizontal,
                reverseDirection = true
            )
            .background(swipeInfo.value.color)
    ) {
        Box(
            Modifier
                .offset {
                    IntOffset(
                        -draggableState
                            .requireOffset()
                            .roundToInt(), 0
                    )
                }
                .matchParentSize()
        ) {
            content()
        }
        if (draggableState.offset != 0f) {
            swipeInfo.value.offsetVal?.let {
                Column(
                    Modifier
                        .offset { -it }
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    swipeInfo.value.icImg?.let {
                        Spacer(Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "",
                            modifier = Modifier.size(imgSize),
                            tint = imgColor
                        )
                        Spacer(Modifier.height(5.dp))
                        textStyle?.let {
                            Text(text = swipeInfo.value.text, style = it, color = textColor)
                        }
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
