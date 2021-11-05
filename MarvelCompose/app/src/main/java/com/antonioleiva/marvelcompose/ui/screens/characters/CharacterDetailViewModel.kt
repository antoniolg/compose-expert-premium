package com.antonioleiva.marvelcompose.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.repositories.CharactersRepository
import com.antonioleiva.marvelcompose.ui.navigation.NavArg
import kotlinx.coroutines.launch

class CharacterDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val id = savedStateHandle.get<Int>(NavArg.ItemId.key) ?: 0

    var state by mutableStateOf(UiState())
        private set

    init {

        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(character = CharactersRepository.find(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val character: Character? = null
    )
}