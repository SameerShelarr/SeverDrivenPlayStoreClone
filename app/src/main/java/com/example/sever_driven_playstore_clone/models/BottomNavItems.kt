package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BottomNavItems(
    @SerialName("items")
    val items: List<BottomNav>,
    @SerialName("orientation")
    val orientation: String
)