package com.antonioleiva.marvelcompose.data.entities

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val comics: List<Reference>,
    val events: List<Reference>,
    val series: List<Reference>,
    val stories: List<Reference>,
)
