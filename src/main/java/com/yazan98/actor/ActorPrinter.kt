package com.yazan98.actor

import com.yazan98.actor.models.ActorApplicationInfo

object ActorPrinter {

    fun printActorStarted(appInfo: ActorApplicationInfo) {
        println("""
            Actor Generator Postman Collection Started ...
            Postman Generator Started ... With Collection
            Application Details : {
                Name : ${appInfo.name}
                Port : ${appInfo.port}
                Description : ${appInfo.description}
                Host : ${appInfo.mainHost}
                Schema : ${appInfo.schema}
                Context Path : ${appInfo.contextPathPattern}
                Postman Collection ID : ${appInfo._postman_id}
            }
        """.trimIndent())
    }

    fun printFinishProcess() {
        println("""
            Actor Generator Finished ...
            You can find the Generated File Result in : /actor/postman-collection.json
            Import The File In Postman Client
        """.trimIndent())
    }

}
