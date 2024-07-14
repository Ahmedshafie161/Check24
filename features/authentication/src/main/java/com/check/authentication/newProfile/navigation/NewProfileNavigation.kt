package com.check.authentication.newProfile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.check.ui.base.util.getNavRoute
import com.check.ui.base.util.getParameterRoute

const val NEW_PROFILE_BASE_ROUTE = "NewProfile_route"
const val NEW_PROFILE_RESOURCE_KEY = "NewProfile_resource_key"
val NewProfile_NAV_ROUTE = getNavRoute(NEW_PROFILE_BASE_ROUTE, NEW_PROFILE_RESOURCE_KEY)

fun NavController.navigateToNewProfile(uri: String? = null) {
    this.navigate(getParameterRoute(NEW_PROFILE_BASE_ROUTE, uri))
}

fun NavGraphBuilder.NewProfileScreen(
    onBackPressed: () -> Unit,
    onAccountCreated: () -> Unit,
) {
    composable(
        route = NewProfile_NAV_ROUTE,
        arguments = listOf(
            navArgument(NEW_PROFILE_RESOURCE_KEY) { type = NavType.StringType },
        ),
    ) {
        val uri = it.arguments?.getString(NEW_PROFILE_RESOURCE_KEY) ?: ""
        NewProfileRoute(onBackPressed = onBackPressed, onAccountCreated = onAccountCreated)
    }
}