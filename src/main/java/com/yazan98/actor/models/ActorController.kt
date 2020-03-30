package com.yazan98.actor.models

data class ActorController<T>(
        var name: String = "Actor Controller",
        var description: String = "Actor Controller Description",
        var item: List<ActorRequest<T>>
)
