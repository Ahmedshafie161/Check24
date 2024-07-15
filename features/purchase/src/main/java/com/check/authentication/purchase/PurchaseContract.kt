package com.check.authentication.purchase

import com.check.authentication.purchase.models.HeaderUiModel
import com.check.authentication.purchase.models.ProductListUiModel
import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState

class PurchaseContract {
    data class State(
        val productListUiModel: ProductListUiModel = ProductListUiModel(
            HeaderUiModel("", ""),
            emptyList(),
            emptyList()
        )
    ) : ViewState

    sealed interface Effect : ViewSideEffect {
//        data object NavigateToNextScreen : Effect
    }

    sealed interface Event : ViewEvent {
//        data class OnSubmitBtnClicked() : Event
    }
}