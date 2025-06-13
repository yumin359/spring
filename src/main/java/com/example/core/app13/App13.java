package com.example.core.app13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App13 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App13.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        Object bean1 = context.getBean("myService");
        Service1 service1 = bean.getService1();
        System.out.println(bean1 == service1);

        // 문제없이 실행되게
        // Service1에 @Component 붙이지 않기
        // AppConfiguration 클래스와 그 안의 메소드
        // 적절한 annotation 들 적용하기
        bean.get();
    }
}
/*
spring bean 만들기
@Component
@Configuration + @Bean

dependency injection
field, setter, constructor
final + @RequiredArgsConstructor

Inversion Of Control (IoC)
DI랑 같은 의미로 보면 된대여
제어의 역전, 제어의 반전

 */