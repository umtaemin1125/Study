package com.in28minutes.learnspringframework.game.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusinessClass{

    //@Autowired //필드 의존성 주입
    Dependency1 dependency1;

    Dependency2 dependency2;

    // @Autowired //생성자 의존성 주입 Autowired를 안써줘도 된다.
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2){
        System.out.println("Constructor Injection - YourBusinessClass ");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

//    @Autowired //setter 의존성 주입
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1 ");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - setDependency2 ");
//        this.dependency2 = dependency2;
//    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1{}

@Component
class Dependency2{}




@Configuration
@ComponentScan
public class DepinjectionLauncherApplication {


    public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(DepinjectionLauncherApplication.class))
    {
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println(context.getBean(YourBusinessClass.class));
    }
        }
}
