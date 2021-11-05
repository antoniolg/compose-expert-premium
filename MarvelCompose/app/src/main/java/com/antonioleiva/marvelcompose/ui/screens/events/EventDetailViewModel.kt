package com.antonioleiva.marvelcompose.ui.screens.events

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.repositories.EventsRepository
import com.antonioleiva.marvelcompose.ui.navigation.NavArg
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val id = savedStateHandle.get<Int>(NavArg.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(event = EventsRepository.find(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val event: Event? = null
    )
}