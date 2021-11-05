package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.network.ApiClient

object ComicsRepository {

    suspend fun get(format: Comic.Format? = null): List<Comic> {
        return ApiClient
            .comicsService
            .getComics(0, 10, format?.toStringFormat())
            .data
            .results
            .map { it.asComic() }
    }

    suspend fun find(id: Int): Comic {
        return ApiClient
            .comicsService
            .findComic(id)
            .data
            .results
            .first()
            .asComic()
    }
}