package com.yazan98.actor.models

data class ActorRequest(
        val name: String,
        val description: String,
        val headers: List<ActorHeader>,
        val path: String
)