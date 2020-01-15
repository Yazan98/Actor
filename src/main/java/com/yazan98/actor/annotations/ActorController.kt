package com.yazan98.actor.annotations

import java.lang.annotation.Inherited


@Inherited
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActorController(
        val name: String,
        val path: String,
        val description: String
)
