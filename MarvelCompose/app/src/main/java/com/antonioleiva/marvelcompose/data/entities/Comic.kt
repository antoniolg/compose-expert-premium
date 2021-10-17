package com.antonioleiva.marvelcompose.data.entities

data class Comic(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val format: Format,
    val characters: List<Reference>,
    val events: List<Reference>,
    val series: List<Reference>,
    val stories: List<Reference>,
    val urls: List<Url>
) {
    enum class Format {
        COMIC,
        MAGAZINE,
        TRADE_PAPERBACK,
        HARDCOVER,
        DIGEST,
        GRAPHIC_NOVEL,
        DIGITAL_COMIC,
        INFINITE_COMIC
    }
}