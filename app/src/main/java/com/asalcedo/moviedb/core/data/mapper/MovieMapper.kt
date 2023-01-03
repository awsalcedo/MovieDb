package com.asalcedo.moviedb.core.data.mapper

import com.asalcedo.moviedb.core.data.remote.MovieApi
import com.asalcedo.moviedb.core.data.remote.dto.MovieResult
import com.asalcedo.moviedb.core.domain.model.Movie

fun MovieResult.toDomain() = Movie(
    id = this.id,
    description = this.overview,
    title = this.title,
    releaseYear = this.releaseDate.substring(0, 4).toInt(),
    language = this.originalLanguage,
    raiting = this.voteAverage,
    poster = MovieApi.IMAGE_URL + this.posterPath,
    genres = this.genreIds
)
