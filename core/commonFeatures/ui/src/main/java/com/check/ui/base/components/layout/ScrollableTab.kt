package com.check.ui.base.components.layout


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.check.designsystem.theme.CustomTheme
import kotlinx.collections.immutable.ImmutableList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedTabIndex by remember { mutableStateOf(0) }
            val tabs = listOf("Fruits", "Vegetables", "Meats", "Miscellaneous")
            CustomScrollableTabRow(
                tabs = tabs,
                selectedTabIndex = selectedTabIndex,
            ) { tabIndex ->
                selectedTabIndex = tabIndex
            }
        }
    }
}

@Composable
fun CustomScrollableTabRow(
    backgroundColor: Color = CustomTheme.colors.Black,
    selectedTextColor: Color = CustomTheme.colors.White,
    unSelectedTextColor: Color = CustomTheme.colors.MediumGrey,
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        contentColor = CustomTheme.colors.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex.coerceIn(0, tabs.lastIndex)],
                    tabWidth = tabWidths[selectedTabIndex.coerceIn(0, tabs.lastIndex)]
                )
            )
        }
        ,
        divider = {}
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        style = CustomTheme.typography.label_14,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        },
                        color = if (selectedTabIndex == tabIndex) selectedTextColor else unSelectedTextColor
                    )
                },
                modifier = Modifier.wrapContentHeight()
            )
        }
    }
}
@Composable
fun <T> CustomScrollableTextTabRow(
    backgroundColor: Color = CustomTheme.colors.Black,
    selectedTextColor: Color = CustomTheme.colors.White,
    unSelectedTextColor: Color = CustomTheme.colors.MediumGrey,
    indicatorColor:Color = CustomTheme.colors.White,
    tabs: ImmutableList<T>,
    selectedTabIndex: Int,
    onTabClick: (T) -> Unit,
    textStyle: TextStyle = CustomTheme.typography.label_14
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }
    ScrollableTabRow(
        modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        contentColor = indicatorColor,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex.coerceIn(0, tabs.lastIndex)],
                    tabWidth = tabWidths[selectedTabIndex.coerceIn(0, tabs.lastIndex)]
                )
            )
        }
        ,
        divider = {}
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tab) },
                text = {
                    Text(
                        text = tab.toString(),
                        style = textStyle,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        },
                        color = if (selectedTabIndex == tabIndex) selectedTextColor else unSelectedTextColor
                    )
                },
                modifier = Modifier.wrapContentHeight()
            )
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}