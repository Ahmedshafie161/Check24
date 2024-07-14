package com.check.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.StaleObjectException
import androidx.test.uiautomator.Until

fun MacrobenchmarkScope.testScroll() {
    // handle scrolling
    device.wait(Until.hasObject(By.scrollable(true)), 5_000)

    val list = device.findObject(By.res("feed_list"))
    val listChildren = By.hasChild(By.res("feed_list"))
    device.wait(Until.hasObject(listChildren), 5_000)
    list.setGestureMargin(device.displayWidth / 5)
    try {
        repeat(3) {
            list.fling(Direction.DOWN)
        }
        /*
                repeat(2) {
                    list.fling(Direction.UP)
                }
        */
        device.waitForIdle()
    } catch (e: StaleObjectException) {
        println("StaleObjectException")
    }

    // handle navigation
    val brandImg = list
    val brandImgChildren = By.hasChild(By.res("brandImg"))
    device.wait(Until.hasObject(brandImgChildren), 5_000)
    brandImg?.click()
    device.waitForIdle()
    device.pressBack()
    device.waitForIdle()
}