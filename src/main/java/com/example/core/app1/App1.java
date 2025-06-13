package com.example.core.app1;

public class App1 {
    public static void main(String[] args) {
        // 업무 로직 실행
        Service1 service = new Service1();
        // 생성자를 통해서 Dependency Injection
        Controller1 controller1 = new Controller1(service);
        // setter를 통해서 Dependency Injection
        controller1.setService(service);

        controller1.method1();
    }
}

class Controller1 {

    // dependency(의존성, 의존 객체)
    // field를 통해서 Dependency Injection(DI)
//    Service1 service = new Service1();
    Service1 service;

    public Controller1() {
    }

    // 생성자로 넣을 수도 있고
    public Controller1(Service1 service) {
        this.service = service;
    }

    // setter로 넣을 수도 있고
    public void setService(Service1 service) {
        this.service = service;
    }

    // 위에 없으면 아래 애들 그냥 못 씀.
    public void method1() {
        // 요청 받고
        // CRUD
        service.create();
        // 모델에 값 넣고
        // VIEW forward

    }

    public void method2() {
        // 요청받고
        service.read();
        // 모델에 넣고
        // view forward
    }
}

class Service1 {
    public void create() {
        // 새 데이터 입력 코드
    }

    public void read() {
        // 기존 데이터 조회 코드
    }
}