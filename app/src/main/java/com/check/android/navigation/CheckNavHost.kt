package com.check.android.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.check.android.navigation.bottomNavBar.BottomNavigation
import com.check.authentication.newProfile.navigation.NewProfileScreen
import com.check.authentication.newProfile.navigation.NewProfile_NAV_ROUTE

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckNavHost(startDestination: String = NewProfile_NAV_ROUTE) {

    val navController = rememberNavController()
    Scaffold(modifier = Modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = { BottomNavigation(navController) }) {
        NavHost(
            modifier = Modifier.semantics { testTagsAsResourceId = true },
            navController = navController,
            startDestination = startDestination
        ) {

            NewProfileScreen(
                onBackPressed = { navController.popBackStack() },
                onAccountCreated = {
                navController.popBackStack()
//                navController.navToNextScreen()
            })
        }
    }
}