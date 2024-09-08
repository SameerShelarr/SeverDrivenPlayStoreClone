package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class App(
    @SerialName("icon")
    val icon: String,
    @SerialName("icon_size")
    val iconSize: Size,
    @SerialName("rating")
    val rating: Double,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("subtitle_font_size")
    val subtitleFontSize: Int,
    @SerialName("title")
    val title: String,
    @SerialName("title_font_size")
    val titleFontSize: Int
)