package com.check.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.check.android.navigation.CheckNavHost
import com.check.designsystem.theme.CheckTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val state = viewModel.viewState
        installSplashScreen().apply {
            setKeepVisibleCondition {
                state.value.isLoading
            }
        }
        setContent {
            CheckTheme {
                CheckNavHost()
            }
        }
    }
}