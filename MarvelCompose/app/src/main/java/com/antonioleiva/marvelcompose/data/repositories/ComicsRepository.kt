package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.entities.Result
import com.antonioleiva.marvelcompose.data.entities.tryCall
import com.antonioleiva.marvelcompose.data.network.remote.ComicsService
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val service: ComicsService) {

    suspend fun get(format: Comic.Format? = null): Result<List<Comic>> = tryCall {
        service
            .getComics(0, 10, format?.toStringFormat())
            .data
            .results
            .map { it.asComic() }
    }

    suspend fun find(id: Int): Result<Comic> = tryCall {
        service
            .findComic(id)
            .data
            .results
            .first()
            .asComic()
    }
}