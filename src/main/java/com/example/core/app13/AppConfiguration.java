package com.example.core.app13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean // 이 spring bean의 이름은 메소드 이름으로 결정
    public Service1 myService() { // 메소드 이름이 Spring Bean의 이름이 됨
        return new Service1();
    }

    // Bean 여러개 만들 수 있다.
    @Bean
    public Service2 myService2() {
        return new Service2();
    }
}
