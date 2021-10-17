package com.antonioleiva.marvelcompose.data.network.entities

data class ApiCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ApiThumbnail,
    val comics: ApiReferenceList,
    val events: ApiReferenceList,
    val series: ApiReferenceList,
    val stories: ApiReferenceList,
    val urls: List<ApiUrl>,
    val modified: String,
    val resourceURI: String
)