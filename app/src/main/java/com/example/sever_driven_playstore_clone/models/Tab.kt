package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tab(
    @SerialName("font_size")
    val fontSize: Int,
    @SerialName("icon_size")
    val iconSize: Size,
    @SerialName("showRedDot")
    val showRedDot: Boolean,
    @SerialName("title")
    val title: String
)