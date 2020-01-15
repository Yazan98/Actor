package com.yazan98.actor

import com.yazan98.actor.processor.ActorProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*


@SpringBootApplication
@com.yazan98.actor.annotations.ActorApplication(
        name = "",
        description = "",
        port = 8090,
        host = "localhost",
        enabled = true
)
open class ActorApplication

fun main(args: Array<String>) {
    runApplication<ActorApplication>(*args)
}

