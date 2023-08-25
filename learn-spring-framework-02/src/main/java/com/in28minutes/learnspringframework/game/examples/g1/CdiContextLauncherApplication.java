package com.in28minutes.learnspringframework.game.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
@Component
    class BusinessService{
        private DataService dataService;


        public DataService getDataService() {
            System.out.println("Setter Injection");
            return dataService;
        }

        @Autowired
        public void setDataService(DataService dataService) {
            this.dataService = dataService;
        }
    }

    @Component
    class DataService {

    }

    public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class))
    {
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
        }
}
