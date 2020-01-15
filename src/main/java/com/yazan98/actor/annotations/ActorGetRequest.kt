package com.yazan98.actor.annotations

import com.yazan98.actor.utils.GetRequestType
import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target


@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
annotation class ActorGetRequest(
        val name: String,
        val path: String,
        val type: GetRequestType,
        val headers: Array<String>
)