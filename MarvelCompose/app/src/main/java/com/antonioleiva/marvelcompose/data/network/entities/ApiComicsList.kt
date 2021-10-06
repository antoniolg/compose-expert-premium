package com.antonioleiva.marvelcompose.data.network.entities

data class ApiComicsList(
    val available: Int,
    val collectionURI: String,
    val items: List<ApiComic>,
    val returned: Int
)