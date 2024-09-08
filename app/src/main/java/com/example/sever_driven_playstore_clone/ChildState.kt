package com.example.sever_driven_playstore_clone

import com.google.firebase.database.DatabaseError

sealed class ChildState<T : Any> {

    /**
     * This state is represents a new child is added to the location to which this listener was added.
     */
    data class ChildAdded<T : Any>(
        val value: T?,
        val previousChildName: String?,
    ) : ChildState<T>()

    /**
     * This state is represents the data at a child location has changed.
     */
    data class ChildChanged<T : Any>(
        val value: T?,
        val previousChildName: String?,
    ) : ChildState<T>()

    /**
     * This state is represents a child is removed from the location to which this listener was added.
     */
    data class ChildRemoved<T : Any>(
        val value: T?,
    ) : ChildState<T>()

    /**
     * This state is represents a child location's priority changes.
     */
    data class ChildMoved<T : Any>(
        val value: T?,
        val previousChildName: String?,
    ) : ChildState<T>()

    /**
     * This state is represents the event that this listener either failed at the server,
     * or is removed as a result of the security and Firebase rules.
     */
    data class ChildCanceled<T : Any>(
        val error: DatabaseError,
    ) : ChildState<T>()
}