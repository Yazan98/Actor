package com.yazan98.actor.annotations;

import com.yazan98.actor.ActorConsts;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActorController {

    String name();
    String description() default ActorConsts.DEFAULT_CONTROLLER_DESCRIPTION;

}
