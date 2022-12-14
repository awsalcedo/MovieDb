package com.asalcedo.moviedb.core.domain.repository

import com.asalcedo.moviedb.core.domain.model.Movie

interface MovieRepository {
    suspend fun getUpcomingMovies(): Result<List<Movie>>
    suspend fun getPopularMovies(): Result<List<Movie>>
}