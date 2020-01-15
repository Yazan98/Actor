package com.yazan98.actor.annotations

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.lang.annotation.Inherited


@Inherited
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActorApplication(
        val name: String,
        val host: String,
        val port: Int,
        val enabled: Boolean,
        val description: String
)
