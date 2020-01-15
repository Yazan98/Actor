package com.yazan98.actor;

import com.yazan98.actor.annotations.Actor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Actor(enabled = true , application = ActorApplication.class, description = "HEHEHEHE")
public class ActorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActorApplication.class, args);
    }

}
