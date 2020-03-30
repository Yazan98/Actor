package com.yazan98.actor.models

data class ActorRequest<T>(
        var name: String = "Actor Request",
        var request: ActorRequestContent<T>
)
