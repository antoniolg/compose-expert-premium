package com.antonioleiva.marvelcompose.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemDetailScreen
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemsListScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CharactersScreen(
    onClick: (Character) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    MarvelItemsListScreen(
        loading = state.loading,
        items = state.characters,
        onClick = onClick
    )
}

@ExperimentalMaterialApi
@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    MarvelItemDetailScreen(
        loading = state.loading,
        marvelItem = state.character
    )
}