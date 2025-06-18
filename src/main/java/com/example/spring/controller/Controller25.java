package com.example.spring.controller;

import com.example.spring.service.Service7;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main25")
public class Controller25 {

    private final Service7 service7;


    @RequestMapping("sub1")
    public String sub1() {
        service7.action1();

        return "main25/sub1";
    }

    @RequestMapping("sub2")
    public String sub2() {
        service7.action2();
        return "main25/sub2";
    }

    // 카테고리 조회
    // /main25/sub3?id=3
    @GetMapping("sub3")
    public String sub3(Integer id) {
        service7.action3(id);
        return "main25/sub3";
    }

    // 상품조회
    // /main25/sub4?id=2
    @GetMapping("sub4")
    public String sub4(Integer id) {
        service7.action4(id);
        return "main25/sub4";
    }

    /// ///////

    // 직원 정보 입력
    // /main25/sub5
    @RequestMapping("sub5")
    public String sub5() {
        service7.action5();
        return "main25/sub5";
    }

    // 상품 정보 입력
    // /main25/sub6
    @RequestMapping("sub6")
    public String sub6() {
        service7.action6();
        return "main25/sub6";
    }

    // 직원 정보 조회
    @GetMapping("sub7")
    public String sub7(Integer id) {
        service7.action7(id);
        return "main25/sub7";
    }

    // 직원이 처리한 상품들 조회
    @GetMapping("sub8")
    public String sub8(Integer id) {
        service7.aciton8(id);
        return "main25/sub8";
    }

    @GetMapping("sub9")
    public String sub9(Integer id) {
        service7.action9(id);
        return "main25/sub9";
    }

}
