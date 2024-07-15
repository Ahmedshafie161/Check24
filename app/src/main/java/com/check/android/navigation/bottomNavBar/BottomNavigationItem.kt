package com.check.android.navigation.bottomNavBar

import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import androidx.navigation.NavController
import com.check.R
import com.check.authentication.purchase.navigation.PURCHASE_NAV_ROUTE

@Stable
data class BottomNavigationItem(
    @StringRes val title: Int? = null,
    val unselectedIcon: Int,
    val selectedIcon: Int = unselectedIcon,
    val screenRoute: String,
    val shouldShowBottomSheetAfterNav: Boolean = true,
    var isSelected: Boolean = false,
    val navigate: (navController: NavController) -> Unit
)

val bottomNavBarItems = listOf(
    BottomNavigationItem(
        title = R.string.feed,
        unselectedIcon = R.drawable.ic_unselected_feed,
        selectedIcon = R.drawable.ic_selected_feed,
        screenRoute = PURCHASE_NAV_ROUTE,
        shouldShowBottomSheetAfterNav = true,
        isSelected = true,
        navigate = { }
    ),
    BottomNavigationItem(
        title = R.string.brands,
        unselectedIcon = R.drawable.ic_unselected_brands,
        selectedIcon = R.drawable.ic_selected_brands,
        screenRoute = PURCHASE_NAV_ROUTE,
        shouldShowBottomSheetAfterNav = true,
        navigate = { }
    ),
    BottomNavigationItem(
        unselectedIcon = R.drawable.ic_camera,
        selectedIcon = R.drawable.ic_camera,
        screenRoute = PURCHASE_NAV_ROUTE,
        shouldShowBottomSheetAfterNav = false,
        navigate = { }
    ),
    BottomNavigationItem(
        title = R.string.cart,
        unselectedIcon = R.drawable.ic_unselected_cart,
        selectedIcon = R.drawable.ic_selected_cart,
        screenRoute = "rewards",
        shouldShowBottomSheetAfterNav = true,
        navigate = { }
    ),
    BottomNavigationItem(
        title = R.string.profile,
        unselectedIcon = R.drawable.ic_unselected_profile,
        selectedIcon = R.drawable.ic_selected_profile,
        screenRoute = "more",
        navigate = { }
    )
)
