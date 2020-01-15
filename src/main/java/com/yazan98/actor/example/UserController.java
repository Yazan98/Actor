package com.yazan98.actor.example;

import com.yazan98.actor.annotations.ActorController;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ActorController(name = "Users Api" , description = "Users Api Description")
public class UserController {

}
