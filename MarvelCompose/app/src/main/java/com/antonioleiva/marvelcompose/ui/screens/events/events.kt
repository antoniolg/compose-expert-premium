package com.antonioleiva.marvelcompose.ui.screens.events

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemDetailScreen
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemsListScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun EventsScreen(
    onClick: (Event) -> Unit,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    MarvelItemsListScreen(
        items = state.events,
        onClick = onClick,
        loading = state.loading
    )
}

@ExperimentalMaterialApi
@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MarvelItemDetailScreen(state.loading, state.event)
}