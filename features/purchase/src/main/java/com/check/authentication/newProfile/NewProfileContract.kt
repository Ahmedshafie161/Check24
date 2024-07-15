package com.check.authentication.newProfile

import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState

class NewProfileContract {
    data class State(val id:Int = 0) : ViewState

    sealed interface Effect : ViewSideEffect {
//        data object NavigateToNextScreen : Effect
    }

    sealed interface Event : ViewEvent {
//        data class OnSubmitBtnClicked() : Event
    }
}