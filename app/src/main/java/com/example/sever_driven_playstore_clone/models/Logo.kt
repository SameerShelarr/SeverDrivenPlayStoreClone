package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Logo(
    @SerialName("size")
    val size: Size,
    @SerialName("title")
    val title: Title,
    @SerialName("url")
    val url: String
)