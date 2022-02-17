package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.entities.Result
import com.antonioleiva.marvelcompose.data.network.remote.CharactersService
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val service: CharactersService) : Repository<Character>() {

    suspend fun get(): Result<List<Character>> = super.get {
        service
            .getCharacters(0, 100)
            .data
            .results
            .map { it.asCharacter() }
    }

    suspend fun find(id: Int): Result<Character> = super.find(
        id,
        findActionRemote = {
            service
                .findCharacter(id)
                .data
                .results
                .first()
                .asCharacter()
        }
    )
}