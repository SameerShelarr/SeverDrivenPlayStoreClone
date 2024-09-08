package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppBarSection(
    @SerialName("bell_icon")
    val bellIcon: BellIcon,
    @SerialName("logo")
    val logo: Logo,
    @SerialName("order")
    val order: Int
)