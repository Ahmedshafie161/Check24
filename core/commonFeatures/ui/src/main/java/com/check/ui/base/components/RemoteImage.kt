package com.check.ui.base.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.check.core.commonFeatures.ui.R
import com.check.designsystem.Constants
import timber.log.Timber

@Composable
fun RemoteImageCard(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    description: String? = null,
    alignment: Alignment = Alignment.Center,
    placeholder: Painter = painterResource(id = android.R.drawable.sym_action_chat),
    contentScale: ContentScale = ContentScale.Crop,
    withShimmer: Boolean = false,
    alpha: Float = DefaultAlpha,
) {
    val contentScaleState = remember { mutableStateOf(contentScale) }
    val showShimmer = remember { mutableStateOf(true) }
    Card(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            placeholder = if (withShimmer.not()) placeholder else null,
            contentDescription = description,
            modifier = if (withShimmer) {
                Modifier.fillMaxSize()
            } else Modifier.fillMaxSize(),
            alignment = alignment,
            contentScale = contentScaleState.value,
            alpha = alpha,
            error = placeholder,
            onSuccess = { showShimmer.value = false },
            onError = {
                showShimmer.value = false
                Timber.tag(Constants.TimberTag).e(it.result.throwable)
            },
        )
    }
}

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    description: String? = null,
    alignment: Alignment = Alignment.Center,
    placeholder: Painter = painterResource(id = R.drawable.ic_black),
    contentScale: ContentScale = ContentScale.Crop,
    withShimmer: Boolean = false,
    alpha: Float = DefaultAlpha,
) {
    val contentScaleState = remember { mutableStateOf(contentScale) }
    val showShimmer = remember { mutableStateOf(withShimmer) }
    Box(modifier = modifier) {
        AsyncImage(
            model = imageUrl,
//            placeholder = if (withShimmer.not()) placeholder else null,
            contentDescription = description,
            modifier = if (withShimmer) {
                Modifier.fillMaxSize()
            } else Modifier
                .fillMaxSize()
                .shimmerBrush(targetValue = 1300f, showShimmer = { showShimmer.value }),
            alignment = alignment,
            contentScale = contentScaleState.value,
            alpha = alpha,
            error = placeholder,
            onSuccess = { showShimmer.value = false },
            onError = {
                showShimmer.value = false
                Timber.tag(Constants.TimberTag)
                    .e(it.result.throwable.message + ", cause : " + it.result.throwable.message)
            },
        )
    }
}

@Composable
fun Modifier.shimmerBrush(
    showShimmer: ()-> Boolean = { true },
    targetValue: Float = 1000f,
    timer: Int = 1000
): Modifier {
    val brush = if (showShimmer()) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.0f),
            Color.LightGray.copy(alpha = 0.8f),
            Color.LightGray.copy(alpha = 0.0f),
        )

        val transition = rememberInfiniteTransition(label = "")
        val translateAnimation = transition.animateFloat(
            initialValue = -targetValue,
            targetValue = targetValue * 5,
            animationSpec = infiniteRepeatable(tween(timer, 0, LinearEasing), RepeatMode.Restart),
            label = ""
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(listOf(Color.Transparent, Color.Transparent), Offset.Zero, Offset.Zero)
    }
    return this then Modifier.drawBehind { drawRect(brush) }
}