package com.antonioleiva.marvelcompose.ui.screens.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.repositories.EventsRepository
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(events = EventsRepository.get())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val events: List<Event> = emptyList()
    )
}