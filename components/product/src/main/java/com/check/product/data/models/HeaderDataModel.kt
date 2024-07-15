package com.check.product.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HeaderDataModel(
    @SerializedName("headerTitle")
    val headerTitle: String,
    @SerializedName("headerDescription")
    val headerDescription: String)

