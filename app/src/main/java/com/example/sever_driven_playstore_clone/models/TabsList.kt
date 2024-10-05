package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TabsList(
    @SerialName("items")
    val items: List<Tab>,
    @SerialName("font_size")
    val fontSize: Int,
)