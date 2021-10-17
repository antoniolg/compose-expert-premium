package com.antonioleiva.marvelcompose.data.repositories

abstract class Repository<T> {

    private var cache: List<T> = emptyList()

    internal suspend fun get(getAction: suspend () -> List<T>): List<T> {
        if (cache.isEmpty()) {
            cache = getAction()
        }
        return cache
    }

    internal suspend fun find(
        findActionLocal: (T) -> Boolean,
        findActionRemote: suspend () -> T
    ): T {
        val character = cache.find { findActionLocal(it) }
        if (character != null) return character

        return findActionRemote()
    }

}