# Actor
Postman Collection Generator To Generate Spring Boot Requests From The Controllers To Postman

# Overview
Actor is an Postman Collection Generator to Generate Api Requests From Controllers to Postman Collection
Without Repeat Everything always and this library is just for people who just using Postman For Api Documentation

# Binray Info

[Bintray Link](https://bintray.com/yt98/Actor/Actor)

# Supported Languages
1. Java
2. Kotlin

# Setup

Maven Implementation

```
<dependency>
  <groupId>com.yazan98.actor</groupId>
  <artifactId>springboot-postman</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>

<!-- Json Required For Parsing The Objects -->
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20190722</version>
</dependency>

```

Gradle

```

// Json Required For Parsing The Objects
implementation group: 'org.json', name: 'json', version: '20190722'
implementation 'com.yazan98.actor:springboot-postman:0.0.1'

```

# Testing Usage

1. Main Class

```
@SpringBootApplication
open class ActorApplication : ActorApp {
    override fun getApplicationInfo(): ActorApplicationInfo {
        return ActorApplicationInfo(
                name = "Actor Testing Api",
                description = "Actor Testing Description",
                port = "8090",
                mainHost = "localhost"
        )
    }

    override fun getCollectionMapper(): ActorMapper {
        return ControllerMappers()
    }

}

fun main(args: Array<String>) {
    runApplication<ActorApplication>(*args)
    ActorApplicationStarter.startCollectionGenerator(ActorApplication())
}

```

2. Define Controllers

```

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
```

# License

Copyright (C) 2019 Actor is An Open Source Library (Licensed under the Apache License, Version 2.0)

