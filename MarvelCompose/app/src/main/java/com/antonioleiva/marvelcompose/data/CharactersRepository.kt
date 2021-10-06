package com.antonioleiva.marvelcompose.data

import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.network.ApiClient
import com.antonioleiva.marvelcompose.data.network.entities.asString

class CharactersRepository {

    suspend fun getCharacters(): List<Character> {
        val response = ApiClient.charactersService.getCharacters(0, 100)
        return response.data.results.map {
            Character(it.id, it.name, it.description, it.thumbnail.asString())
        }
    }
}