package com.yazan98.actor.processor;

import com.yazan98.actor.ActorConsts;
import com.yazan98.actor.annotations.Actor;
import com.yazan98.actor.annotations.ActorController;
import com.yazan98.actor.models.ActorApplicationInformation;
import com.yazan98.actor.models.ActorControllerInformation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.util.*;

public class ActorProcessor extends AbstractProcessor {

    private String defaultHost;
    private String defaultPort;
    private ArrayList<ActorControllerInformation> controllerInformations;
    private ActorApplicationInformation applicationInfo;
    private Set<String> supportedAnnotationTypes;
    private Messager messager;

    public ActorProcessor() {
        this.supportedAnnotationTypes = new HashSet<>();
        this.applicationInfo = new ActorApplicationInformation();
        this.supportedAnnotationTypes.add("com.yazan98.actor.annotations.Actor");
        this.controllerInformations = new ArrayList<>();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Collection<? extends Element> annotatedElements = roundEnvironment.getElementsAnnotatedWith(Actor.class);
        List<TypeElement> types = ElementFilter.typesIn(annotatedElements);
        for (Element element : annotatedElements) {
            if (element.getKind() != ElementKind.CLASS) {
                messager.printMessage(Diagnostic.Kind.ERROR, ActorConsts.ACTOR_NOT_ON_CLASS);
                return false;
            } else {
                startExecuteAfterFirstValidate(types, roundEnvironment);
            }
        }
        return true;
    }

    private void startExecuteAfterFirstValidate(List<TypeElement> types, RoundEnvironment environment) {
        for (TypeElement type : types) {
            Actor applicationAnnotation = type.getAnnotation(Actor.class);
            if (applicationAnnotation.enabled()) {
                this.applicationInfo.setApplicationName(applicationAnnotation.application().getSimpleName() + ActorConsts.DEFAULT_NAME);
                this.applicationInfo.setDescription(applicationAnnotation.description());
                this.applicationInfo.setSchema(ActorConsts.DEFAULT_SCHEMA);
                this.applicationInfo.setId(UUID.randomUUID().toString());
                this.defaultHost = applicationAnnotation.serverHost();
                this.defaultPort = applicationAnnotation.serverPort();
                startExecuteControllerValidation(environment);
            } else {
                break;
            }
        }
    }

    private void startExecuteControllerValidation(RoundEnvironment environment) {
        Collection<? extends Element> annotatedElements = environment.getElementsAnnotatedWith(ActorController.class);
        List<TypeElement> types = ElementFilter.typesIn(annotatedElements);
        for (TypeElement element : types) {
            controllerInformations.add(new ActorControllerInformation());
        }
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return supportedAnnotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

}
