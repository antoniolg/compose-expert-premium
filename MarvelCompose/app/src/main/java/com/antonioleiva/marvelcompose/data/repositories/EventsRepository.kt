package com.antonioleiva.marvelcompose.data.repositories

import com.antonioleiva.marvelcompose.data.entities.Event
import com.antonioleiva.marvelcompose.data.entities.Result
import com.antonioleiva.marvelcompose.data.network.remote.EventsService

class EventsRepository(private val service: EventsService) : Repository<Event>() {

    suspend fun get(): Result<List<Event>> = super.get {
        service
            .getEvents(0, 100)
            .data
            .results
            .map { it.asEvent() }
    }

    suspend fun find(id: Int): Result<Event> = super.find(
        id,
        findActionRemote = {
            service
                .findEvent(id)
                .data
                .results
                .first()
                .asEvent()
        }
    )
}