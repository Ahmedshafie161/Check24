package com.check.purchaseProductList

import com.check.purchaseProductList.models.ProductListUiModel
import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState

class PurchaseContract {
    data class State(
        val purchaseState: PurchaseState = PurchaseState.Loading,
        val isRefreshing: Boolean = false
    ) : ViewState

    sealed interface Effect : ViewSideEffect {
//        data object NavigateToNextScreen : Effect
    }

    sealed interface Event : ViewEvent {
        data object OnDismissAlertDialog : Event
        data object Refresh : Event
    }
}

sealed interface PurchaseState {
    data object Loading : PurchaseState
    data class Data(val productListUiModel: ProductListUiModel) : PurchaseState
    data object Error : PurchaseState
}