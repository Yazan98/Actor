package com.yazan98.actor.models

import com.yazan98.actor.ActorRequests

data class ActorRequestContent<T>(
        var method: ActorRequests = ActorRequests.GET,
        var headers: List<ActorRequestHeader>,
        var url: ActorRequestUrl,
        var body: Class<T>
)