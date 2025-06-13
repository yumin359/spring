package com.example.core.app4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App4 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App4.class, args);
        Controller1 b1 = context.getBean(Controller1.class);// 빈 이름이나 클래스명을 쓰면됨
        Service1 b2 = context.getBean(Service1.class);// 빈 이름이나 클래스명을 쓰면됨
        b1.method1();
        b2.action1();

        b1.method2(); // NullPointerException
    }
}

@Component
class Controller1 {
    @Autowired // field 기반 dependency injection
    Service1 service;

    public void method2() {
        System.out.println("서비스 메소드 실행");
        service.action1();
    }

    public void method1() {
        System.out.println("Controller1 method1");
    }
}

@Component
class Service1 {
    public void action1() {
        System.out.println("Service1 method1");
    }
}