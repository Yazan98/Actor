package com.yazan98.actor.controllers

import com.yazan98.actor.annotations.ActorController
import org.springframework.web.bind.annotation.RestController

@RestController
@ActorController(name = "Service Api" , description = "Service Api" , path = "/path")
class ServiceController {
}
