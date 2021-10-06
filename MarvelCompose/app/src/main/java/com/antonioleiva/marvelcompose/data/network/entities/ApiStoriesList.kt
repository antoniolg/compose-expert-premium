package com.antonioleiva.marvelcompose.data.network.entities

data class ApiStoriesList(
    val available: Int,
    val collectionURI: String,
    val items: List<ApiStory>,
    val returned: Int
)