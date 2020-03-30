package com.yazan98.actor.models

data class ActorController(
        var name: String = "Actor Controller",
        var description: String = "Actor Controller Description",
        var item: List<ActorRequest>
)
