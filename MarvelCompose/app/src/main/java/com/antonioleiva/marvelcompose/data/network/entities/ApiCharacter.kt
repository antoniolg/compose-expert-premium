package com.antonioleiva.marvelcompose.data.network.entities

data class ApiCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ApiThumbnail,
    val comics: ApiComicsList,
    val events: ApiEventsList,
    val series: ApiSeriesList,
    val stories: ApiStoriesList,
    val urls: List<ApiUrl>,
    val modified: String,
    val resourceURI: String
)