package com.check.authentication.newProfile.navigation;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.check.authentication.newProfile.NewProfileViewModel
import com.check.authentication.newProfile.composables.NewProfileScreen
import com.check.ui.base.sideEffect
import com.check.ui.base.viewState

@Composable
internal fun NewProfileRoute(
    modifier: Modifier = Modifier,
    viewModel: NewProfileViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    onAccountCreated: () -> Unit,
) {
//    LaunchedEffect(Unit) { viewModel.init() }
    val state = viewModel.viewState()
    NewProfileScreen(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        onEvent = { viewModel.handleEvents(it) },
        state = { state },
        onBackPressed = onBackPressed
    )
    viewModel.sideEffect { effect ->
        when (effect) {
            else -> {}
        }
    }
}