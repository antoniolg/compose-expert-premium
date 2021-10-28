package com.antonioleiva.marvelcompose.data.entities

data class Comic(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnail: String,
    val format: Format,
    override val references: List<ReferenceList>,
    override val urls: List<Url>
) : MarvelItem {
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