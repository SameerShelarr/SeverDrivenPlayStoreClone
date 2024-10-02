package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BellIcon(
    @SerialName("shouldShowRedDot")
    val shouldShowRedDot: Boolean,
    @SerialName("size")
    val size: Size,
    @SerialName("url")
    val url: String
)