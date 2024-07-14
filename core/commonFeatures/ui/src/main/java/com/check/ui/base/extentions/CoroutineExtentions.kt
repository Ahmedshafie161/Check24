package com.check.ui.base.extentions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.util.concurrent.atomic.AtomicReference

class LazySuspend<T>(
    private val block: suspend () -> T,
) {
    private val value = AtomicReference<Deferred<T>>()

    suspend operator fun invoke(): T = (
            value.get()
                ?: coroutineScope {
                    value.updateAndGet { actual ->
                        actual ?: async { block() }
                    }
                }
            ).await()
}

fun <T> CoroutineScope.lazyCoroutine(
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    return async(start = CoroutineStart.LAZY) { block() }
}