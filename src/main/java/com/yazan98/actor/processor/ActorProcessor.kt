package com.yazan98.actor.processor

import com.google.auto.service.AutoService
import com.yazan98.actor.ActorConsts
import com.yazan98.actor.annotations.ActorApplication
import com.yazan98.actor.annotations.ActorController
import com.yazan98.actor.annotations.ActorGetRequest
import com.yazan98.actor.models.ActorApplicationInfo
import com.yazan98.actor.models.ActorRequestInfo
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.util.ElementFilter
import javax.tools.Diagnostic
import kotlin.collections.ArrayList

@SupportedAnnotationTypes(value = [
    "com.yazan98.actor.annotations.ActorApplication",
    "com.yazan98.actor.annotations.ActorController",
    "com.yazan98.actor.annotations.ActorGetRequest"
])
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(ActorProcessor::class)
open class ActorProcessor : AbstractProcessor() {

    private lateinit var messager: Messager
    private val applicationDetails: ActorApplicationInfo by lazy {
        ActorApplicationInfo()
    }

    private val controllers: ArrayList<ActorRequestInfo> by lazy {
        ArrayList<ActorRequestInfo>()
    }

    init {
        println("Processor Called")
    }

    override fun init(processingEnv: ProcessingEnvironment?) {
        super.init(processingEnv)
        processingEnv?.let {
            messager = it.messager
        }
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(
                ActorApplication::class.java.name,
                ActorController::class.java.name,
                ActorGetRequest::class.java.name
        )
    }

    override fun process(p0: MutableSet<out TypeElement>?, environment: RoundEnvironment?): Boolean {
        environment?.let {
            executeProjectAnnotation(it)
        }
        return true
    }

    private fun executeProjectAnnotation(environment: RoundEnvironment) {
        val annotatedElements: Collection<Element> = environment.getElementsAnnotatedWith(ActorApplication::class.java)
        val types = ElementFilter.typesIn(annotatedElements)
        for (element in annotatedElements) {
            if (element.kind != ElementKind.CLASS) {
                messager.printMessage(Diagnostic.Kind.ERROR, ActorConsts.ACTOR_NOT_ON_CLASS)
            } else {
                startExecuteAfterFirstValidate(types, environment)
            }
        }
    }

    private fun startExecuteAfterFirstValidate(types: List<TypeElement>, environment: RoundEnvironment) {
        for (type in types) {
            val applicationAnnotation: ActorApplication = type.getAnnotation(ActorApplication::class.java)
            if (applicationAnnotation.enabled) {
                this.applicationDetails.name = "${applicationAnnotation.name}-${ActorConsts.DEFAULT_NAME}"
                this.applicationDetails.description = applicationAnnotation.description
                this.applicationDetails.schema = (ActorConsts.DEFAULT_SCHEMA)
                this.applicationDetails.id = (UUID.randomUUID().toString())
                this.applicationDetails.host = applicationAnnotation.host
                this.applicationDetails.port = applicationAnnotation.port.toString()
                startExecuteControllerValidation(environment)
            } else {
                break
            }
        }
    }

    private fun startExecuteControllerValidation(environment: RoundEnvironment) {
        val annotatedElements: Collection<Element?> = environment.getElementsAnnotatedWith(ActorController::class.java)
        val types = ElementFilter.typesIn(annotatedElements)
        annotatedElements.forEach {
            if(it?.kind != ElementKind.CLASS) {
                messager.printMessage(Diagnostic.Kind.ERROR, ActorConsts.CONTROLLER_CLASS_ERROR)
            }
        }
        for (element in types) {
            val controller: ActorController = element.getAnnotation(ActorController::class.java)
            controllers.add(ActorRequestInfo(
                    controller.name,
                    controller.description
            ))
        }
        controllers.forEach {
            println("The Controller : $it")
        }
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.RELEASE_10
    }

}
