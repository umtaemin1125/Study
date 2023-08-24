package com.in28minutes.learnspringframework.game.examples.d1;

import com.in28minutes.learnspringframework.game.examples.c1.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
    private ClassA classA;

    public ClassB(ClassA classA){
        //다양한 로직을 선언할 수 있음.
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do Something");
    }
}



@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {


    public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class))
    {
//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);

        System.out.println("Initialization of context is completed");
        context.getBean(ClassB.class).doSomething();

    }
    }
}
