package com.example.sever_driven_playstore_clone.di

import com.example.sever_driven_playstore_clone.BuildConfig
import com.example.sever_driven_playstore_clone.MainViewModel
import com.example.sever_driven_playstore_clone.PlayStoreRepository
import com.google.firebase.Firebase
import com.google.firebase.database.database
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(get()) }

    single { PlayStoreRepository(get()) }

    single {
        Firebase.database(BuildConfig.FIREBASE_REALTIME_DB_URL).reference
    }
}