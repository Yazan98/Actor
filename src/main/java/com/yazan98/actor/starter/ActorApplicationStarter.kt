package com.yazan98.actor.starter

import com.yazan98.actor.printers.ActorPrinter

object ActorApplicationStarter {

    fun startCollectionGenerator(info: ActorApp) {
        ActorPrinter.printActorStarted(info.getApplicationInfo())

        ActorPrinter.printFinishProcess()
    }

}