package com.yazan98.actor.models

data class ActorRequestUrl(
        var raw: String,
        var description: String = "",
        var protocol: String = "http",
        var host: List<String> = arrayListOf("localhost"),
        var port: String = "8080",
        var query: List<ActorRequestQuery>
)