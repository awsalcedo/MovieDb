package com.asalcedo.moviedb.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asalcedo.moviedb.core.domain.model.Movie
import com.asalcedo.moviedb.home.presentation.FilterType

@Composable
fun HomeRecommended(
    selectedFilter: FilterType,
    onFilterClick: (FilterType) -> Unit,
    movieList: List<Movie>,
    modifier: Modifier,
    onMovieClick: (Movie) -> Unit
) {
    if (movieList.isNotEmpty()){
        Column(modifier = modifier.fillMaxWidth()) {

            CategoryTitle(title = "Recomendados para ti", modifier = modifier)

            Spacer(modifier = modifier.height(12.dp))

            FilterPillContainer(
                filters = FilterType.values().toList(),
                selectedFilter = selectedFilter,
                onFilterClick = onFilterClick
            )
        }
    }


}