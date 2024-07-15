package com.check.authentication.purchase

import androidx.lifecycle.viewModelScope
import com.check.authentication.purchase.models.toProductListUiModel
import com.check.product.domain.usecases.FetchProductListUseCase
import com.check.ui.base.BaseViewModel
import com.check.ui.base.IGlobalState
import com.check.ui.base.extentions.execIOResMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
            else -> {}
        }
    }
    fun init (){
        if(isIntialized.not()){
            setState { currentState.copy(isLoading = true) }
            viewModelScope.launch(Dispatchers.IO) {
                fetchProductListUseCase().fold(
                    onSuccess = {
                        setState { currentState.copy(it.toProductListUiModel(),false) }},
                    onFailure = {setState { currentState.copy(isLoading = false) }}
                )
            }
            isIntialized = true
        }
    }
}