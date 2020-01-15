package com.yazan98.actor.controllers

import com.yazan98.actor.annotations.ActorController
import org.springframework.web.bind.annotation.RestController

@RestController
@ActorController(name = "User Api" , description = "User Api" , path = "/path")
class UserController {
}