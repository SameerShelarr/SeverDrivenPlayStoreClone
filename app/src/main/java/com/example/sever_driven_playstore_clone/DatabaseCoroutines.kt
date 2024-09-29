@file:Suppress("UNCHECKED_CAST", "unused")

package com.example.sever_driven_playstore_clone

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.json.JSONObject

/**
 * Returns a flow that emits a target object [T] from the specified [path] within the [DatabaseReference].
 *
 * The flow emits a [Result], encapsulating both the snapshot value and any potential errors.
 */

fun <T : Any> DatabaseReference.flow(
    path: (DataSnapshot) -> DataSnapshot,
    decodeProvider: (String) -> T?,
): Flow<Result<T?>> = callbackFlow {
    val listener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val data = path.invoke(snapshot).serializedValue(decodeProvider)
            trySend(Result.success(data))
        }

        override fun onCancelled(error: DatabaseError) {
            trySend(Result.failure(error.toException()))
        }
    }
    addValueEventListener(listener)

    awaitClose { removeEventListener(listener) }
}

private fun <T> DataSnapshot.serializedValue(
    decodeProvider: (String) -> T,
): T? {
    val map: Map<String, Any> = value as? Map<String, Any> ?: return null
    val jsonString = JSONObject(map).toString().replace("\\/", "/")
    val data = decodeProvider.invoke(jsonString)
    return data
}