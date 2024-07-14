package com.check.ui.base.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import timber.log.Timber

@Composable
fun LogComposable(msg: String){
    SideEffect {
        Timber.tag("SHAFIE_Composable").d(msg)
    }
}