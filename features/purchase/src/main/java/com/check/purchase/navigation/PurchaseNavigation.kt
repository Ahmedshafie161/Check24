package com.check.purchase.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.check.ui.base.util.getNavRoute
import com.check.ui.base.util.getParameterRoute

const val PURCHASE_BASE_ROUTE = "purchase_route"
const val PURCHASE_RESOURCE_KEY = "purchase_resource_key"
val PURCHASE_NAV_ROUTE = getNavRoute(PURCHASE_BASE_ROUTE, PURCHASE_RESOURCE_KEY)

fun NavController.navigateToPurchase(uri: String? = null) {
    this.navigate(getParameterRoute(PURCHASE_BASE_ROUTE, uri))
}

fun NavGraphBuilder.PurchaseScreen(
    onBackPressed: () -> Unit,
    onAccountCreated: () -> Unit,
) {
    composable(
        route = PURCHASE_NAV_ROUTE,
        arguments = listOf(
            navArgument(PURCHASE_RESOURCE_KEY) { type = NavType.StringType },
        ),
    ) {
        val uri = it.arguments?.getString(PURCHASE_RESOURCE_KEY) ?: ""
        PurchaseRoute(onBackPressed = onBackPressed, onAccountCreated = onAccountCreated)
    }
}