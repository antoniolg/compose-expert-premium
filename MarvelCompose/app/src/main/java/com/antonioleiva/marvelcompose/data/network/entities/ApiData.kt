package com.antonioleiva.marvelcompose.data.network.entities

data class ApiData<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)