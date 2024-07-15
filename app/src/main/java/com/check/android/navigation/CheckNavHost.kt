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
import com.check.purchase.navigation.PurchaseScreen
import com.check.purchase.navigation.PURCHASE_NAV_ROUTE

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckNavHost(startDestination: String = PURCHASE_NAV_ROUTE) {

    val navController = rememberNavController()
    Scaffold(modifier = Modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        ) {
        NavHost(
            modifier = Modifier.semantics { testTagsAsResourceId = true },
            navController = navController,
            startDestination = startDestination
        ) {

            PurchaseScreen(
                onBackPressed = { navController.popBackStack() },
                onAccountCreated = {
                navController.popBackStack()
//                navController.navToNextScreen()
            })
        }
    }
}