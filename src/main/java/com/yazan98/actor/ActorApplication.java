package com.yazan98.actor;

import com.yazan98.actor.annotations.ActorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@com.yazan98.actor.annotations.ActorApplication(
        name = "Actor Example",
        description = "Actor Description Collection",
        enabled = true,
        host = "localhost",
        port = 8080
)
public class ActorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActorApplication.class, args);
    }

}

@ActorController(name = "Controller 1" , description = "Controller Description", path = "")
class Controller1 {

}

@ActorController(name = "Controller 2" , description = "Controller Description" , path = "")
class C2 {

}
