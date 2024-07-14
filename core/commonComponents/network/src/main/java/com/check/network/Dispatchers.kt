package com.check.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val niaDispatcher: CheckDispatchers)

enum class CheckDispatchers {
    Default,
    IO,
}
