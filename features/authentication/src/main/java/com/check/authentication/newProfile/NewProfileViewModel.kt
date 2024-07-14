package com.check.authentication.newProfile

import com.check.ui.base.BaseViewModel
import com.check.ui.base.IGlobalState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewProfileViewModel @Inject constructor(globalState: IGlobalState) : BaseViewModel<NewProfileContract.Event, NewProfileContract.State, NewProfileContract.Effect>(globalState) {


    override fun setInitialState() = NewProfileContract.State()
    override fun handleEvents(event: NewProfileContract.Event) {
        when (event) {
            else -> {}
        }
    }
}