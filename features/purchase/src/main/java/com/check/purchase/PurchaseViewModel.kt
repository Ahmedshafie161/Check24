package com.check.purchase

import androidx.lifecycle.viewModelScope
import com.check.purchase.models.toProductListUiModel
import com.check.product.domain.usecases.FetchProductListUseCase
import com.check.ui.base.BaseViewModel
import com.check.ui.base.IGlobalState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PurchaseViewModel @Inject constructor(
    globalState: IGlobalState,
    private val fetchProductListUseCase: FetchProductListUseCase
) : BaseViewModel<PurchaseContract.Event, PurchaseContract.State, PurchaseContract.Effect>(globalState) {

    var isIntialized = false
    override fun setInitialState() = PurchaseContract.State()
    override fun handleEvents(event: PurchaseContract.Event) {
        when (event) {
            PurchaseContract.Event.OnDismissAlertDialog -> setState { currentState.copy(PurchaseState.Loading) }
            PurchaseContract.Event.Refresh -> refresh()
        }
    }
    fun init (){
        if(isIntialized.not()){
            setState { currentState.copy(PurchaseState.Loading) }
            fetchProductAndPopulateUi()
            isIntialized = true
        }
    }

    private fun fetchProductAndPopulateUi() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchProductListUseCase().fold(
                onSuccess = {
                    setState { currentState.copy(PurchaseState.Data(it.toProductListUiModel())) }
                },
                onFailure = {
                    setState { currentState.copy(PurchaseState.Error) }
                }
            )
        }
    }

    fun refresh(){
        fetchProductAndPopulateUi()
    }
}