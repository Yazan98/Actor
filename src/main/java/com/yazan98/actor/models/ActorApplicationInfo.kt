package com.yazan98.actor.models

import com.yazan98.actor.ActorContextPath
import java.util.*

data class ActorApplicationInfo(
     var name: String = "Actor Api",
     var description: String = "Api Documentation Generated With Actor",
     var schema: String = "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
     var _postman_id: String = UUID.randomUUID().toString(),
     var contextPathPattern: ActorContextPath = ActorContextPath.HTTP,
     var port: String = "8080",
     var mainHost: String = "localhost"
)
