package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class App(
    @SerialName("icon")
    val icon: String,
    @SerialName("rating")
    val rating: Double,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("title")
    val title: String,
)