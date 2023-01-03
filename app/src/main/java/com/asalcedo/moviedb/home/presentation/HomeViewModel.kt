package com.asalcedo.moviedb.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.moviedb.core.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            supervisorScope {
                val upcoming = launch { getUpcomingMovies() }
                val popular = launch { getPopularMovies() }
                listOf(upcoming, popular).forEach { it.join() }
                state = state.copy(
                    isLoading = false
                )
            }
        }
    }

    private suspend fun getUpcomingMovies() {
        viewModelScope.launch {
            repository.getUpcomingMovies().onSuccess { movies ->
                state = state.copy(
                    upcomingMovies = movies
                )
            }.onFailure {
                println()
            }
        }
    }

    private suspend fun getPopularMovies() {
        viewModelScope.launch {
            repository.getPopularMovies().onSuccess { movies ->
                state = state.copy(
                    popularMovies = movies
                )
            }.onFailure {
                println()
            }
        }
    }
}