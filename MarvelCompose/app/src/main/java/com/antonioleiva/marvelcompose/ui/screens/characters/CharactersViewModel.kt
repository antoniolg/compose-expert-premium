package com.antonioleiva.marvelcompose.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.data.repositories.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(characters = CharactersRepository.get())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val characters: List<Character> = emptyList()
    )
}