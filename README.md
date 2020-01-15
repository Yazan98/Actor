# Actor
Postman Collection Generator To Generate Spring Boot Requests From The Controllers To Postman

## Overview
This Project is An Annotation Processor To Generate All Files, Collections From The Spring Controllers Via Annotations

## Requirements
1. Jdk : 1.8
2. Kotlin Reflect
3. Kotlin Kapt Plugin

## Project Status
Under Development

## Simple View About The Project
```
@SpringBootApplication
@com.yazan98.actor.annotations.ActorApplication(
        name = "",
        description = "",
        port = 8090,
        host = "localhost",
        enabled = true
)
open class ActorApplication

fun main(args: Array<String>) {
    runApplication<ActorApplication>(*args)
}
```

```
@RestController
@ActorController(name = "Service Api" , description = "Service Api" , path = "/path")
class ServiceController {
}
```
