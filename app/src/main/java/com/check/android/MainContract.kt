package com.check.android;

import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState

class MainContract {
    data class State(
        val uiModel: UserDataUiModel? = null,
        val isLoading : Boolean = true ,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data class NavigateToImpactScreen(val userData: UserDataUiModel) :Navigation()
        }

            object AppStarted :Effect()
    }

    sealed class Event : ViewEvent {

    }
}