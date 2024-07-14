package com.check.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    /*  @Test
    // run without baseline profile
      fun startUpCompilationModeNone() = startup(CompilationMode.None())*/

    // run with baseline profile
    @Test
    fun startUpCompilationModePartial() = startup(CompilationMode.Partial())

    fun startup(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = "com.check.android",
        metrics = listOf(StartupTimingMetric()),
        iterations = 10,
        startupMode = StartupMode.COLD,
        compilationMode = mode
    ) {
        pressHome()
        startActivityAndWait()
    }
}

