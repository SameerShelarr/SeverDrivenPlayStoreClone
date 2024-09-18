package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Apps(
    @SerialName("items")
    val items: List<App>,
    @SerialName("orientation")
    val orientation: String,
    @SerialName("icon_size")
    val iconSize: Size,
    @SerialName("subtitle_font_size")
    val subtitleFontSize: Int,
    @SerialName("title_font_size")
    val titleFontSize: Int,
)