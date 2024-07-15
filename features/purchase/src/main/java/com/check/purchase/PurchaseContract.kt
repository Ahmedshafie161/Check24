package com.check.purchase

import com.check.purchase.models.HeaderUiModel
import com.check.purchase.models.ProductListUiModel
import com.check.purchase.models.ProductUiModel
import com.check.ui.base.ViewEvent
import com.check.ui.base.ViewSideEffect
import com.check.ui.base.ViewState
import kotlinx.collections.immutable.toImmutableList
import okhttp3.internal.immutableListOf

class PurchaseContract {
    data class State(
        val productListUiModel: ProductListUiModel = ProductListUiModel(
            HeaderUiModel("", ""),
            emptyList<String>().toImmutableList(),
            emptyList<ProductUiModel>().toImmutableList()
        ),
        val isLoading: Boolean = false
    ) : ViewState

    sealed interface Effect : ViewSideEffect {
//        data object NavigateToNextScreen : Effect
    }

    sealed interface Event : ViewEvent {
//        data class OnSubmitBtnClicked() : Event
    }
}