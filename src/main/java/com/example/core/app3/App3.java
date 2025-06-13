package com.example.core.app3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App3 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App3.class, args);

        // context 에서 getBean() 메소드로
        // com.example.core.app3.Controller1 로 만든 객체 꺼내서
        // method1() 실행시켜보기
        Object bean1 = context.getBean("controller1");
        if (bean1 instanceof Controller1 c) {
            c.method1();
        }

        Controller1 bean = context.getBean(Controller1.class);
        bean.method1();

        System.out.println(bean == bean1); // true

        // 패키지가 달라도 컨트롤러 이름을 다르게 해줘야 Bean 합칠 때 문제가 안 생긴대여 졸리다
    }
}
