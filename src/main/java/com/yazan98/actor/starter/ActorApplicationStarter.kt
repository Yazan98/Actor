package com.yazan98.actor.starter

import com.yazan98.actor.ActorPrinter
import com.yazan98.actor.executers.ActorResultMapper

object ActorApplicationStarter {

    private val applicationMapper: ActorResultMapper by lazy {
        ActorResultMapper()
    }

    fun startCollectionGenerator(info: ActorApp) {
        ActorPrinter.printActorStarted(info.getApplicationInfo())
        applicationMapper.applyApplicationInfo(info.getApplicationInfo())
        applicationMapper.applyActorRequests(info.getCollectionMapper().getControllers())
        applicationMapper.printAppResult()
        ActorPrinter.printFinishProcess()
    }

}
