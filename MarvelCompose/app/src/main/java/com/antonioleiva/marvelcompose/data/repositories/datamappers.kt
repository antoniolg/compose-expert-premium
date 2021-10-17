package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.entities.Reference
import com.antonioleiva.marvelcompose.data.entities.Url
import com.antonioleiva.marvelcompose.data.network.entities.ApiCharacter
import com.antonioleiva.marvelcompose.data.network.entities.ApiComic
import com.antonioleiva.marvelcompose.data.network.entities.ApiReferenceList
import com.antonioleiva.marvelcompose.data.network.entities.asString

fun ApiCharacter.asCharacter(): Character {
    val comics = comics.toDomain()
    val events = events.toDomain()
    val series = series.toDomain()
    val stories = stories.toDomain()
    val urls = urls.map { Url(it.type, it.url) }
    return Character(
        id,
        name,
        description,
        thumbnail.asString(),
        comics,
        events,
        series,
        stories,
        urls
    )
}

fun ApiComic.asComic(): Comic {
    val characters = characters.toDomain()
    val events = events.toDomain()
    val series = series.toDomain()
    val stories = stories.toDomain()
    val urls = urls.map { Url(it.type, it.url) }
    return Comic(
        id,
        title,
        description ?: "",
        thumbnail.asString(),
        format.toDomain(),
        characters,
        events,
        series,
        stories,
        urls
    )
}

private fun String.toDomain(): Comic.Format = when (this) {
    "magazine" -> Comic.Format.MAGAZINE
    "trade paperback" -> Comic.Format.TRADE_PAPERBACK
    "hardcover" -> Comic.Format.HARDCOVER
    "digest" -> Comic.Format.DIGEST
    "graphic novel" -> Comic.Format.GRAPHIC_NOVEL
    "digital comic" -> Comic.Format.DIGITAL_COMIC
    "infinite comic" -> Comic.Format.INFINITE_COMIC
    else -> Comic.Format.COMIC
}

fun Comic.Format.toStringFormat(): String = when (this) {
    Comic.Format.COMIC -> "comic"
    Comic.Format.MAGAZINE -> "magazine"
    Comic.Format.TRADE_PAPERBACK -> "trade paperback"
    Comic.Format.HARDCOVER -> "hardcover"
    Comic.Format.DIGEST -> "digest"
    Comic.Format.GRAPHIC_NOVEL -> "graphic novel"
    Comic.Format.DIGITAL_COMIC -> "digital comic"
    Comic.Format.INFINITE_COMIC -> "infinite comic"
}

private fun ApiReferenceList.toDomain(): List<Reference> =
    items
        ?.let { items.map { Reference(it.name) } }
        ?: emptyList()