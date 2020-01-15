package com.yazan98.actor.annotations;

import com.yazan98.actor.ActorMethod;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActorPostRequest {

    ActorMethod method();

    Class<?> body();

    String path();

    String name();

}
