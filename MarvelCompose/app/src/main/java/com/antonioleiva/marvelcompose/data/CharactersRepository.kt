package com.antonioleiva.marvelcompose.data

import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.entities.Reference
import com.antonioleiva.marvelcompose.data.network.ApiClient
import com.antonioleiva.marvelcompose.data.network.entities.ApiCharacter
import com.antonioleiva.marvelcompose.data.network.entities.asString

object CharactersRepository {

    suspend fun getCharacters(): List<Character> {
        val response = ApiClient.charactersService.getCharacters(0, 100)
        return response.data.results.map { it.asCharacter() }
    }

    suspend fun findCharacter(characterId: Int): Character {
        val response = ApiClient.charactersService.findCharacter(characterId)
        return response.data.results.first().asCharacter()
    }
}

private fun ApiCharacter.asCharacter(): Character {
    val comics = comics.items.map { Reference(it.name) }
    val events = events.items.map { Reference(it.name) }
    val series = series.items.map { Reference(it.name) }
    val stories = stories.items.map { Reference(it.name) }
    return Character(
        id,
        name,
        description,
        thumbnail.asString(),
        comics,
        events,
        series,
        stories
    )
}