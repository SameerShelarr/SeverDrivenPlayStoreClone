package com.example.sever_driven_playstore_clone

import android.app.Application
import com.example.sever_driven_playstore_clone.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ServerDrivenPlayStoreCloneApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ServerDrivenPlayStoreCloneApp)
            modules(
                appModule
            )
        }
    }
}