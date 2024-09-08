package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BellIcon(
    @SerialName("count")
    val count: Int,
    @SerialName("handler")
    val handler: Handler,
    @SerialName("scaleType")
    val scaleType: String,
    @SerialName("shouldShowCount")
    val shouldShowCount: Boolean,
    @SerialName("size")
    val size: Size,
    @SerialName("url")
    val url: String
)