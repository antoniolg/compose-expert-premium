package com.antonioleiva.marvelcompose.ui.screens.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.repositories.EventsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(events = EventsRepository.get())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val events: List<Event> = emptyList()
    )
}