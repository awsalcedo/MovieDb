package com.asalcedo.moviedb.home.presentation

import com.asalcedo.moviedb.core.domain.model.Movie

sealed class HomeEvent {
    data class ChangeFilter(val filterType: FilterType) : HomeEvent()
    data class OnMovieClick(val movieId: Int) : HomeEvent()

}