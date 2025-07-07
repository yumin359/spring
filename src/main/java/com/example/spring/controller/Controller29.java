package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/main29")
@ResponseBody
public class Controller29 {

    @PostMapping("sub1")
    public String sub1() {
        System.out.println("Controller29.sub1");
        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller29.sub2");
        return null;
    }

    // 연습 : react에서 3번째 버튼 만들고 클릭해서 아래 메소드가 일하게
    @PostMapping("sub3")
    public String sub3() {
        System.out.println("Controller29.sub3");
        return null;
    }

    @PostMapping("sub4")
    public String sub4(@RequestBody Map<String, Object> map) {
        // @RequestBody : JSON을 해당 타입(Map)으로 역직렬화(디코딩, 파싱) 해주는 어노테이션
        System.out.println("Controller29.sub4");
        System.out.println("map = " + map);
        return null;
    }

    @PostMapping("sub5")
    public String sub5(@RequestBody Map<String, Object> map) {
        System.out.println("Controller29.sub5");
        System.out.println("map = " + map); // {address=seoul, score=88.12, country=korea}
        return null;
    }

}
