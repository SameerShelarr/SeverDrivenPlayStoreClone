package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BottomNav(
    @SerialName("icon")
    val icon: String,
    @SerialName("title")
    val title: String
)