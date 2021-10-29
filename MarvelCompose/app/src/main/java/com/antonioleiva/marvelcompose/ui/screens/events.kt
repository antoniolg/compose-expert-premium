package com.antonioleiva.marvelcompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import coil.annotation.ExperimentalCoilApi
import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.repositories.EventsRepository
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemDetailScreen
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemsListScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun EventsScreen(onClick: (Event) -> Unit) {
    var eventsState by remember() { mutableStateOf(emptyList<Event>()) }
    LaunchedEffect(Unit) {
        eventsState = EventsRepository.get()
    }
    MarvelItemsListScreen(
        items = eventsState,
        onClick = onClick
    )
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun EventDetailScreen(eventId: Int, onUpClick: () -> Unit) {
    var eventState by remember { mutableStateOf<Event?>(null) }
    LaunchedEffect(Unit) {
        eventState = EventsRepository.find(eventId)
    }
    eventState?.let {
        MarvelItemDetailScreen(it, onUpClick)
    }
}