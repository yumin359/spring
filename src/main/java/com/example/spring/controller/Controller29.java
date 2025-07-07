package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
