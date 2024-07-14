package com.check.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.check.benchmark.util.testScroll
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScrollNavigationBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    /* @Test
     fun scrollAndNavigateCompilationModeNone() = scrollAndNavigate(CompilationMode.None())*/

    // run with baseline profile
    @Test
    fun scrollAndNavigateCompilationModePartial() = scrollAndNavigate(CompilationMode.Partial())

    fun scrollAndNavigate(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = "com.check.android",
        metrics = listOf(FrameTimingMetric()),
        iterations = 10,
        startupMode = StartupMode.COLD,
        compilationMode = mode
    ) {
        pressHome()
        startActivityAndWait()
        testScroll()
    }
}