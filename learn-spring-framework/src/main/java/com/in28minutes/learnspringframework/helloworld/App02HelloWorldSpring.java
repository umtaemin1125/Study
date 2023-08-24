package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1. Spring 애플리케이션이나 Spring Context 실행하는 단계

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        //2. 스프링 프레임워크가 관리도록 할 것을 설정 --@Configuration
        //HelloWorldConfiguration - @Configuration
        //name - @Bean 설정

        //3. 스프링이 관리하는 Beans를 검색
        System.out.println(context.getBean("name"));

        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));

        System.out.println(context.getBean("address"));
    }
}
