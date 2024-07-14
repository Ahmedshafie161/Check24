package com.check.ui.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.check.ui.base.extentions.consume

@Composable
fun <T : ViewState> BaseViewModel<*, T, *>.viewState() =
    viewState.collectAsStateWithLifecycle()

@Composable
fun <T : ViewSideEffect> BaseViewModel<*, *, T>.sideEffect(action: (effect: T) -> Unit) =
    effect.consume(action = action)