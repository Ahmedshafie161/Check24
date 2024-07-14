package com.check.ui.base.extentions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.check.designsystem.Constants.TimberCoroutineTag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import timber.log.Timber

fun <T> ViewModel.execIOResMain(
    scope: CoroutineScope = viewModelScope,
    backgroundFun: suspend () -> T?,
    foreGroundFun: suspend (T) -> Unit = {}
) : Job {
    return scope.launch(Dispatchers.IO) {
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:started")
        val result = backgroundFun()
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:finished result $result")
        withContext(Dispatchers.Main) {
            result?.let {
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground started")
                foreGroundFun(it)
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground finished")
            }
        }
    }
}
suspend fun <T> ViewModel.execSuSIOResMain(
    backgroundFun: suspend () -> T?,
    foreGroundFun: (T) -> Unit = {}
)  {
     withContext(Dispatchers.IO) {
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:started")
        val result = backgroundFun()
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:finished result $result")
        withContext(Dispatchers.Main) {
            result?.let {
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground started")
                foreGroundFun(it)
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground finished")
            }
        }
    }
}
fun ViewModel.execAsyncIOResMain(
    scope: CoroutineScope = viewModelScope,
    backgroundFun: suspend () -> Unit,
    foreGroundFun: suspend () -> Unit = {}
) {
    scope.launch(Dispatchers.Main.immediate) {
        Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground started")
        foreGroundFun()
        Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground finished")
    }
    scope.launch(Dispatchers.IO) {
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:started")
        val result = backgroundFun()
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:finished result $result")
    }
}
fun <T> ViewModel.execIOResSafeMain(
    backgroundFun: suspend () -> T?,
    foreGroundFun: (T) -> Unit = {}
) {
    viewModelScope.launch(Dispatchers.IO) {
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:started")
        val result = backgroundFun()
        Timber.tag(TimberCoroutineTag).d("${backgroundFun.javaClass.name },coroutine:background:finished result $result")
        withContext(Dispatchers.Main) {
            result?.let {
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground started")
                foreGroundFun(it)
                Timber.tag(TimberCoroutineTag).d("${foreGroundFun.javaClass.name },coroutine foreground finished")
            }
        }
    }
}

fun <T> ViewModel.executeResultMain(
    backgroundFun: suspend () -> T?,
    foreGroundFun: (T) -> Unit
) {
    viewModelScope.launch(Dispatchers.Main) {
        val result = backgroundFun()
        result?.let {
            foreGroundFun(it)
        }
    }
}
fun <T> ViewModel.executeBlockingMain(
    backgroundFun: suspend () -> T?,
    foreGroundFun: (T) -> Unit
) {
    val result = runBlocking {
        backgroundFun()
    }

    result?.let {
        foreGroundFun(it)
    }
}

fun <T> ViewModel.executeIO(
    backgroundFun: suspend () -> T?,
) {
    viewModelScope.launch(Dispatchers.IO) {
        val result = backgroundFun()
    }
}