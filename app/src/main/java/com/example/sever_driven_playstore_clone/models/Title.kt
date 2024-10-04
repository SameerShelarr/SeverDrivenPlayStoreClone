package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    @SerialName("fontWeight")
    val fontWeight: String,
    @SerialName("size")
    val size: Int,
    @SerialName("text")
    val text: String,
    @SerialName("shouldShowTitle")
    val shouldShowTitle: Boolean
)