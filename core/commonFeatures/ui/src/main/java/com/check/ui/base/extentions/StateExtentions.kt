package com.check.ui.base.extentions

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.yield

suspend fun <T> MutableStateFlow<T>.updateWithMutex(block: suspend (currentValue: T) -> T) {
    Mutex().withLock {
        value = block(value)
    }
}

suspend fun <T> MutableStateFlow<T>.updateWithMutexCurrent(block: suspend (currentValue: T, updateValue: (T) -> Unit) -> Unit) {
    Mutex().withLock {
        block(value) { newValue ->
            value = newValue
        }
    }
}

suspend fun <T> MutableStateFlow<T>.updateWithMutexCurrently(
    operation: suspend (updateValue: suspend (T) -> Unit) -> Unit
) {
    val mutex = Mutex()
    operation { newValue ->
        mutex.withLock {
            value = newValue
        }
    }
}

suspend fun <T, I> MutableStateFlow<T>.updateForEach(
    iterable: Iterable<I>,
    transform: suspend T.(index: Int, I) -> T
) {
    val mutex = Mutex()
    iterable.forEachIndexed { index, item ->
        mutex.withLock {
            value = value.transform(index, item)
            yield()
        }
        println("Processed item: $item, new state: $value")
    }
}

suspend fun <T> MutableStateFlow<T>.updateWithMutex(vararg blocks: suspend (currentValue: T) -> T) {
    Mutex().withLock {
        blocks.forEach { block ->
            value = block(value)
        }
    }
}