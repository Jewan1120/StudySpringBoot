package com.jewan.learnspringframework.examples.g1;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import jakarta.inject.Inject;
import jakarta.inject.Named;

// CDI : Context and Dependency Injection -> 스프링의 어노테이션을 대체

// @Component
@Named // @Component와 동일
class BusinessService {
    DataService dataService;

    // @Autowired
    @Inject // @Autowired와 동일
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}


// @Component
@Named
class DataService {

}

 
@Configuration
@ComponentScan
public class CdiContextLaucherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CdiContextLaucherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
