package com.asalcedo.moviedb.core.domain.model

data class Movie(
    val id: Int,
    val description: String,
    val title: String,
    val releaseYear: Int,
    val language: String,
    val raiting: Double,
    val poster: String,
    val genres: List<Int>
)
