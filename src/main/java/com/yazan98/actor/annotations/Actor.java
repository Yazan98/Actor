package com.yazan98.actor.annotations;

import com.yazan98.actor.ActorApplication;
import com.yazan98.actor.ActorConsts;

import java.lang.annotation.*;


@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Actor {

    boolean enabled() default true;

    Class<?> application() default ActorApplication.class;

    String description() default ActorConsts.DEFAULT_DESCRIPTION;

    String serverHost();

    String serverPort();

}
