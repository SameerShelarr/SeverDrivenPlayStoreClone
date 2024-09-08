package com.example.sever_driven_playstore_clone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sever_driven_playstore_clone.models.PlayStoreHome
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    repo: PlayStoreRepository,
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val playStoreHomeFlow = repo.getPlayStoreHomeUi()
        .flatMapLatest { flowOf(it.getOrNull()) }
        .filterNotNull()
        .map {
            PlayStoreHome(
                appBarSection = it.appBarSection,
                appsListSection = it.appsListSection,
                bottomNavSection = it.bottomNavSection,
                tabsSection = it.tabsSection,
                version = it.version,
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
}