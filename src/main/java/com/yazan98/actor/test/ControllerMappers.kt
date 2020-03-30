package com.yazan98.actor.test

import com.yazan98.actor.ActorMapper
import com.yazan98.actor.ActorRequests
import com.yazan98.actor.models.*

class ControllerMappers : ActorMapper {
    override fun getControllers(): List<ActorController> {
        return arrayListOf(
                ActorController(
                        "Register Controller",
                        "Profile Managment Api's",
                        arrayListOf(
                                ActorRequest(
                                        "Create Account",
                                        ActorRequestContent(
                                                ActorRequests.POST,
                                                headers = arrayListOf(
                                                        ActorRequestHeader(),
                                                        ActorRequestHeader("Accept-Language", "ar")
                                                ),
                                                body = Profile::class.java,
                                                url = ActorRequestUrl(
                                                        "http://localhost:8090/v1/accounts",
                                                        "Create New Account",
                                                        "http",
                                                        arrayListOf("localhost"),
                                                        "8090",
                                                        arrayListOf()
                                                )
                                        )
                                )
                        )
                )
        )
    }

    data class Profile(
            val name: String,
            val email: String,
            val title: String
    )
}