package com.yazan98.actor.test

import com.yazan98.actor.ActorMapper
import com.yazan98.actor.models.ActorApplicationInfo
import com.yazan98.actor.starter.ActorApp
import com.yazan98.actor.starter.ActorApplicationStarter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
open class ActorApplication : ActorApp {
    override fun getApplicationInfo(): ActorApplicationInfo {
        return ActorApplicationInfo(
                name = "Actor Testing Api",
                description = "Actor Testing Description",
                port = "8090",
                mainHost = "localhost"
        )
    }

    override fun getCollectionMapper(): ActorMapper {
        return ControllerMappers()
    }

}

fun main(args: Array<String>) {
    runApplication<ActorApplication>(*args)
    ActorApplicationStarter.startCollectionGenerator(ActorApplication())
}
