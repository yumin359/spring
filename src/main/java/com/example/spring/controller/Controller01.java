package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

// @Controller : controller annotation은
//               해당 클래스가 웹 요청을 처리하는 컨트롤러다
//               라는 것을 spring에게 알려주는 annotation.
@Controller
public class Controller01 { // 따라서 이 클래스는 spring 컨트롤러임

    // RequestMapping : path에 해당하는 메소드 호출
    // requestmapping annotation은 요청 URL을 처리할 메소드에 붙임
    // URL과 메소드가 연결 할 수 있게 해주는 것

    // 주소(ip주소:포트번호)/경로?쿼리

    @RequestMapping(path = "/main1/sub1")
    public void method1() {
        System.out.println("Controller01.method1");
    }
    // /main1/sub1 URL 요청이 오면 이 메서드가 실행된다.
    // -> 클라이언트(구글 브라우저 사용)가
    // 192.168.0.38(또는 localhost):8080/main1/sub1을 입력하면
    //          ip 주소는 터미널에 치면 나오는 거
    //          포트번호 8080은 서버 실행시키면 나오는 것임
    // method1() 메서드가 실행됨

    @RequestMapping(path = "/main1/sub2")
    public void some2() {
        System.out.println("Controller01.some2");
    }
    // /main1/sub2 URL 요청이 들어오면 method02() 메서드가 실행됨


    // path 대신 value를 써도 됨. 둘 중 아무거나 써도 됨.
    @RequestMapping(value = "/main1/sub3")
    public void some3() {
        System.out.println("Controller01.some3");
    }
    // /main1/sub3 URL 요청이 들어오면 method02() 메서드가 실행됨
    

    // 두 개의 경로를 한꺼번에 처리
    @RequestMapping(path = {"/main1/sub4", "/main1/sub5"})
    public void some4() {
        System.out.println("Controller01.some4");
    }
    // 해당 경로로 요청시 둘 다 some4() 메서드 실행됨


    // WebRequest : 요청 정보가 담기는 객체
    // 요청에 대한 정보(헤더, 파라미터 등) 를 읽을 수 있는 객체로,
    // 필요할 때만 사용함

    @RequestMapping("/main1/sub6")
    public void some6(WebRequest request) {
        String s = request.getHeader("User-Agent");
        String t = request.getHeader("Accept");
        System.out.println(s);
        System.out.println(t);
        System.out.println("Controller01.some6");
    }
    // 요청에 담긴 헤더 정보들을 가져와서 출력함

}
