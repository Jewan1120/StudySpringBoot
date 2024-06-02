package com.jewan.learnspringframework.examples.e1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 기본적으로 생성된 Bean은 IoC컨테이너에서 싱글톤으로 관리됨
@Component
class NormalClass {

}


// 프로토 타입 클래스
// Bean을 참조할 때마다 새로운 Bean을 사용하고 싶을 땐 프로토 타입으로 선언하면 됨
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}


@Configuration
@ComponentScan
public class BeanScopesLaucherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BeanScopesLaucherApplication.class)) {
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

            // 일반 클래스인 경우 싱글톤 방식으로 Bean을 가져와서 출력 -> 인스턴스가 같음
            // com.jewan.learnspringframework.examples.e1.NormalClass@3ad83a66
            // com.jewan.learnspringframework.examples.e1.NormalClass@3ad83a66

            // 프로토 타입 스코프의 경우 매번 새로운 Bean을 출력 -> 인스턴스가 다름
            // com.jewan.learnspringframework.examples.e1.PrototypeClass@3cce5371
            // com.jewan.learnspringframework.examples.e1.PrototypeClass@17bffc17
            // com.jewan.learnspringframework.examples.e1.PrototypeClass@6e535154

        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
