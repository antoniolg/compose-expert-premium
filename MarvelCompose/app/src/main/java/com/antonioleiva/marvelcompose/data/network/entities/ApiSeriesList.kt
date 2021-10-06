package com.antonioleiva.marvelcompose.data.network.entities

data class ApiSeriesList(
    val available: Int,
    val collectionURI: String,
    val items: List<ApiSeries>,
    val returned: Int
)