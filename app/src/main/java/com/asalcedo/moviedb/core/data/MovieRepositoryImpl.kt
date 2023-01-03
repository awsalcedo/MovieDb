package com.asalcedo.moviedb.core.data

import com.asalcedo.moviedb.core.data.mapper.toDomain
import com.asalcedo.moviedb.core.data.remote.MovieApi
import com.asalcedo.moviedb.core.data.remote.extensions.resultOf
import com.asalcedo.moviedb.core.domain.model.Movie
import com.asalcedo.moviedb.core.domain.repository.MovieRepository

class MovieRepositoryImpl(private val api: MovieApi) : MovieRepository {
    /*override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val results = api.getUpcomingMovies().results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/

    override suspend fun getUpcomingMovies() = resultOf {
        val results = api.getUpcomingMovies().results
        results.map { it.toDomain() }
    }

    /*override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val results = api.getPopularMovies().results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/

    override suspend fun getPopularMovies() = resultOf {
        val results = api.getPopularMovies().results
        results.map { it.toDomain() }
    }
}