package com.asalcedo.moviedb.home.presentation

import com.asalcedo.moviedb.core.domain.model.Movie

data class HomeState(
    val upcomingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)