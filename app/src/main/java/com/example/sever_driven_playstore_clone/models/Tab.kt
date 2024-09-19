package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tab(
    @SerialName("showRedDot")
    val showRedDot: Boolean,
    @SerialName("title")
    val title: String,
    @SerialName("icon")
    val icon: String? = null,
)