package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BottomNavSection(
    @SerialName("list")
    val list: BottomNavItems,
)