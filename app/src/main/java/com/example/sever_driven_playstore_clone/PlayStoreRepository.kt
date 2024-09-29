package com.example.sever_driven_playstore_clone

import com.example.sever_driven_playstore_clone.models.PlayStoreHome
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json

class PlayStoreRepository(
    private val dbRef: DatabaseReference,
) {
    fun getPlayStoreHomeUi(): Flow<Result<PlayStoreHome?>> {
        return dbRef.flow(
            path = { snapshot ->
                snapshot.child("play_store_home")
            },
            decodeProvider = { jsonString ->
                val json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
                try {
                    json.decodeFromString(jsonString)
                } catch (e: Exception) {
                    null
                }
            }
        )
    }
}