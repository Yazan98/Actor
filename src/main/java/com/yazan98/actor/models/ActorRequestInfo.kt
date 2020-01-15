package com.yazan98.actor.models

data class ActorRequestInfo(
        var name: String = "",
        var description: String = "",
        var items: List<ActorRequest> = arrayListOf()
)