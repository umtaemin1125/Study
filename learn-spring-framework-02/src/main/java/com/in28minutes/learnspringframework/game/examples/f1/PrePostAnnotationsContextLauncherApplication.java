package com.in28minutes.learnspringframework.game.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("모든 의존성 준비 완료!!");
    }

    @PostConstruct
    public void initialization(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("CleanUp");
    }
}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("SomeDependency에서 일부 로직 사용");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {


    public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class))
    {
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
        }
}
