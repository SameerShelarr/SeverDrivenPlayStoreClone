package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Apps(
    @SerialName("items")
    val items: List<App>,
    @SerialName("orientation")
    val orientation: String
)