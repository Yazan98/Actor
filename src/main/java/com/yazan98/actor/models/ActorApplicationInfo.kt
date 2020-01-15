package com.yazan98.actor.models

import java.util.*

data class ActorApplicationInfo(
        var id: String = UUID.randomUUID().toString(),
        var name: String = "",
        var description: String = "",
        var schema: String = "",
        var host: String = "localhost",
        var port: String = "8000",
        var item: List<ActorRequestInfo> = arrayListOf()
)