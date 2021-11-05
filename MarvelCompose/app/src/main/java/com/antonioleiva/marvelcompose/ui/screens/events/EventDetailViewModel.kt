package com.antonioleiva.marvelcompose.ui.screens.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.repositories.EventsRepository
import com.antonioleiva.marvelcompose.ui.navigation.NavArg
import kotlinx.coroutines.launch

class EventDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val id = savedStateHandle.get<Int>(NavArg.ItemId.key) ?: 0

    var state by mutableStateOf(UiState())
        private set

    init {

        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(event = EventsRepository.find(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val event: Event? = null
    )
}