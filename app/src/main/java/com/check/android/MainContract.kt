package com.check.android;

import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState

class MainContract {
    data class State(
        val isLoading: Boolean = true,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
        }

        object AppStarted : Effect()
    }

    sealed class Event : ViewEvent {

    }
}