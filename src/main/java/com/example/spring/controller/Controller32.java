package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/main32")
public class Controller32 {

    @GetMapping("sub1")
    @ResponseBody // 리턴 값이 응답 데이터이다
    public String sub1() {
        System.out.println("Controller32.sub1");

        // view 로 forward 가 아니라 client에게 응답하는 값
        return "클라이언트로 전달할 값";
    }

    // 연습 : 두번째 버튼 클릭시 "응답 데이터"가 콘솔에 출력되도록 코드 완성
    @GetMapping("sub2")
    @ResponseBody
    public String sub2() {
        return "응답 데이터";
    }

    @GetMapping("sub3")
    @ResponseBody
    public Map<String, Object> sub3() {
        // 객체(dto, bean)나 map으로 응답 가능
        // -> JSON으로 직렬화 됨
        return Map.of("name", "흥민", "age", 88);
    }

    // 연습 : react에 4번째 버튼 클릭시, "서울, 신촌, 한국" 출력되도록 코드 작성
    @GetMapping("sub4")
    @ResponseBody
    public Map<String, Object> sub4() {
        return Map.of("city", "서울", "address", "신촌", "country", "한국");
    }
}
