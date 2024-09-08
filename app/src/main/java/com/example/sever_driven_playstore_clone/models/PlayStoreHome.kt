package com.example.sever_driven_playstore_clone.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayStoreHome(
    @SerialName("app_bar")
    val appBarSection: AppBarSection,
    @SerialName("apps_list")
    val appsListSection: AppsListSection,
    @SerialName("bottom_nav")
    val bottomNavSection: BottomNavSection,
    @SerialName("tabs")
    val tabsSection: TabsSection,
    @SerialName("version")
    val version: Int
)