package com.check.android;

import androidx.lifecycle.viewModelScope
import com.check.android.MainContract.Effect
import com.check.android.MainContract.Event
import com.check.android.MainContract.State
import com.check.ui.base.BaseViewModel
import com.check.ui.base.IGlobalState
import com.check.ui.base.util.logViewModel
import com.check.product.domain.usecases.FetchProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(globalState: IGlobalState, ) : BaseViewModel<Event, State, Effect>(globalState) {
    override fun setInitialState() = State()
    override fun handleEvents(event: Event) {}

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setState { this.copy(isLoading = true) }
            withContext(Dispatchers.Main.immediate) {
                setState { this.copy(isLoading = false) }
            }
        }
    }
}