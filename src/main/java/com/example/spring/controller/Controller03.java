package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
//@RequestMapping("/main3") // 모든 메소드의 경로 앞 부분에 적용
@RequestMapping("main3") // 모든 메소드의 경로 앞 부분에 적용. /(슬래시 생략 가능)
public class Controller03 {

    // http://localhost:8080/main3/sub1
    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("Controller03.sub1");
    }

    // http://localhost:8080/main3/sub2
    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("Controller03.sub2");
    }

    // 연습
    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("Controller03.sub3");
    }

    // /main3/sub4?param1=val1&param2=val2
    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    // /main3/sub5?address=seoul&age=44&email=gmail&home=dokdo&city=ny&name=donald
    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // request parameter 를 java beans(Data Transaction Object) 로 받기
    // /main3/sub6?name=donald&address=la
    // 값 안 주면 null 로
    @RequestMapping("sub6")
    public void sub6(MyBean031 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress() = " + params.getAddress());
    }

    // /main3/sub7?name=musk&company=tesla&home=texas
    // /main3/sub7?name=musk&company=tesla&home=texas&age=55
    @RequestMapping("sub7")
    public void sub7(MyBean032 params) {
        System.out.println(params);
    }

    // /main3/sub8?nickName=musk&age=55&address=tesla&score=5.5
    @RequestMapping("sub8")
    public void sub8(MyBean033 params) {
        System.out.println(params);
    }

    // /main3/sub9?address=seoul&salary=50.5
    @RequestMapping("sub9")
    public void sub9(MyBean035 params) {
        System.out.println(params);
    }

    // /main3/sub10?age=44&email=gmail&married=true&salary=40.4&name=donald
    // 쿼리스트링 순서랑 클래스에 있는 순서랑은 상관 없대여
    // request handler method 라고 하나봐여
    @RequestMapping("sub10")
    public void sub10(MyBean036 params) {
        System.out.println(params);
    }

    // /main3/sub11?name=dd&address=ny&pw=1234 -> pw null 값
    // /main3/sub11?name=dd&address=ny&password=5678 -> pw 에 5678 들어감

    // request parameter와 같은 이름의 setter 메소드를 사용
    @RequestMapping("sub11")
    public void sub11(MyBean037 params) {
        System.out.println(params);
    }

    // /main3/sub12?name=dd&age=66&skill=work&skill=baseball&skill=java&skill=css
    @RequestMapping("sub12")
    public void sub12(MyBean0310 params) {
        System.out.println(params);
    }

    // 연습
    // /main3/sub13?hobby=cook&hobby=walk&hobby=running&score=3.3&score=4.4&score=5.5
    @RequestMapping("sub13")
    public void sub13(MyBean0311 params, Double[] score) {
        System.out.println(params);
        System.out.println(Arrays.toString(score));
    }


}
