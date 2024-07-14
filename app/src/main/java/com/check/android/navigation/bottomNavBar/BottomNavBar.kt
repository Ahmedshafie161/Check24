package com.check.android.navigation.bottomNavBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.check.R
import com.check.designsystem.theme.CustomTheme
import com.check.ui.base.components.layout.currentRoute

@Composable
fun BottomNavigation(navController: NavController) {
    val shouldShowBottomNavigation =
        bottomNavBarItems.find { it.screenRoute == currentRoute(navController) }?.shouldShowBottomSheetAfterNav

    if (shouldShowBottomNavigation == true) {
        NavigationBar(
            containerColor = Color.Unspecified,
            modifier = Modifier
                .wrapContentHeight()
                .navigationBarsPadding()
        ) {
            bottomNavBarItems.forEach { item ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = if (item.selectedIcon == R.drawable.ic_camera) Color.Unspecified else Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = Color.Transparent,
                        unselectedIconColor = if (item.unselectedIcon == R.drawable.ic_camera) Color.Unspecified else Color.White,
                        unselectedTextColor = Color.White,
                    ),
                    selected = currentRoute(navController) == item.screenRoute,
                    alwaysShowLabel = item.selectedIcon != R.drawable.ic_camera,
                    label = {
                        item.title?.let {
                            Text(
                                text = stringResource(id = item.title),
                                style = if (item.isSelected) CustomTheme.typography.label_12_medium else CustomTheme.typography.label_12_req,
                            )
                        }
                    },
                    onClick = {
                        bottomNavBarItems.forEach { it.isSelected = false }
                        item.isSelected = true
                        item.navigate.invoke(navController)
                    },
                    icon = {
                        Image(
                            painterResource(id = if (item.isSelected) item.selectedIcon else item.unselectedIcon),
                            contentDescription = "",
                            Modifier.background(Color.Transparent)
                        )
                    }
                )
            }
        }
    } else {
        {}
    }
}

@Preview
@Composable
fun TestBottomNavBar() {
    BottomNavigation(navController = rememberNavController())
}
