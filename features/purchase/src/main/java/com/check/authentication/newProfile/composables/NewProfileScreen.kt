package com.check.authentication.newProfile.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.check.authentication.newProfile.NewProfileContract

@Composable
internal fun NewProfileScreen(
    modifier: Modifier,
    onEvent: (NewProfileContract.Event) -> Unit,
    state: () -> State<NewProfileContract.State>,
    onBackPressed: () -> Unit
) {
}

@Preview
@Composable
private fun TestAuthScreen() {
    NewProfileScreen(
        Modifier
            .fillMaxSize()
            .background(Color.Black),
        state = { mutableStateOf(NewProfileContract.State()) },
        onBackPressed = {},
        onEvent = {}
    )
}