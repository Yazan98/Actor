package com.yazan98.actor.starter

import com.yazan98.actor.ActorMapper
import com.yazan98.actor.models.ActorApplicationInfo

interface ActorApp {

    fun getApplicationInfo(): ActorApplicationInfo

    fun getCollectionMapper(): ActorMapper

}
