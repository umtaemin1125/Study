package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//jdk16에서 새로 나온 메서드 => record 사용하면 게터세터생성자 만들 필요 없음! (자동 생성됨)
record Person(String name, int age){};

record Address(String addr1, String addr2){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "taemin";
    }

    @Bean
    public int age(){
        return 26;
    }

    @Bean
    public Person person(){
       return new Person("Taemining", 25);
    }

    @Bean
    public Address address(){
        return new Address("청주시 상당구 용암동", "아파트 101동 1008호");
    }



}
