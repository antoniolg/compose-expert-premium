package com.antonioleiva.marvelcompose.ui.screens.comics

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.repositories.ComicsRepository
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    val state = Comic.Format.values().associate { it to mutableStateOf(UiState()) }

    fun formatRequested(format: Comic.Format) {
        val uiState = state.getValue(format)
        if (uiState.value.comics.isNotEmpty()) return

        viewModelScope.launch {
            uiState.value = UiState(loading = true)
            uiState.value = UiState(comics = ComicsRepository.get(format))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val comics: List<Comic> = emptyList()
    )
}