package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.entities.Result
import com.antonioleiva.marvelcompose.data.entities.tryCall
import com.antonioleiva.marvelcompose.data.network.ApiClient

object ComicsRepository {

    suspend fun get(format: Comic.Format? = null): Result<List<Comic>> = tryCall {
        ApiClient
            .comicsService
            .getComics(0, 10, format?.toStringFormat())
            .data
            .results
            .map { it.asComic() }
    }

    suspend fun find(id: Int): Result<Comic> = tryCall {
        ApiClient
            .comicsService
            .findComic(id)
            .data
            .results
            .first()
            .asComic()
    }
}