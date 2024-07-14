package com.check.ui.base.components.progress

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.check.designsystem.theme.CustomTheme
import kotlinx.coroutines.delay

@Composable
fun AutomaticCircularProgressBar(
    modifier: Modifier = Modifier,
    strokeWidth: Int = 5,
    shouldStartTimer: () -> MutableState<Boolean>,
    onTimerFinished: () -> Unit,
) {
    val recordingTimer = remember { mutableIntStateOf(0) }
    val maxTimerValue = 60 //Seconds
    if (shouldStartTimer().value) {
        LaunchedEffect(Unit) {
            while (recordingTimer.intValue < maxTimerValue) {
                delay(1000)
                recordingTimer.intValue += 1
            }
            onTimerFinished()
        }
    }
    AnimatedCircularProgressIndicator(
        { recordingTimer.intValue },
        maxTimerValue,
        modifier = modifier,
        progressBackgroundColor = CustomTheme.colors.White,
        progressIndicatorColor = CustomTheme.colors.LavaRed,
        completedColor = CustomTheme.colors.LavaRed,
        strokeWidth = strokeWidth
    )
}
