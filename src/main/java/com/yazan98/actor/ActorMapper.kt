package com.yazan98.actor

import com.yazan98.actor.models.ActorController

interface ActorMapper {

    fun getControllers(): List<ActorController<Any>>

}
