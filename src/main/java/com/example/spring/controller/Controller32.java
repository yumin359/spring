package com.example.spring.controller;

import com.example.spring.dto.MyBean321;
import com.example.spring.dto.MyBean322;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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

    @GetMapping("sub5")
    @ResponseBody
    public Map<String, Object> sub5() {
        return Map.of("id", 55, "city", "london",
                "phone", Map.of("phone1", "9999", "phone2", "8888"));
    }

    @GetMapping("sub6")
    @ResponseBody
    public Map<String, Object> sub6() {
        return Map.of("id", 53, "name", "흥민", "address",
                List.of("서울", "런던", "파리"));
    }

    @GetMapping("sub7")
    @ResponseBody
    public MyBean321 sub7() {
        MyBean321 bean = new MyBean321();
        bean.setId(912);
        bean.setName("차범근");
        bean.setFruits(List.of("apple", "lemon"));
        bean.setAddress(Map.of("city", "신촌", "country", "한국"));
        // json
        // {"id": 912, "name": "차범근",
        // "fruits": ["apple", "lemon"],
        // "address": {"city": "신촌", "country": "한"}}
        return bean;
    }

    // 연습 : react 에 8번째 버튼 클릭시 dto의 모든 값을 출력하는 코드 완성
    @GetMapping("sub8")
    @ResponseBody
    public MyBean322 sub8() {
        MyBean322 myBean322 = new MyBean322();
        myBean322.setId(912);
        myBean322.setTitle("소년이");
        myBean322.setCategory(Map.of("author", "한강", "genre", "소설"));
        myBean322.setOrders(List.of("교보", "알라딘"));
        myBean322.setPrice(9000.00);
        return myBean322;
    }

    // ResponseEntity : 상태코드(response status code)를 설정해서 응답 가능한 객체
    @GetMapping("sub9")
    @ResponseBody
    public ResponseEntity sub9() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("sub10")
    @ResponseBody
    public ResponseEntity sub10() {
        return ResponseEntity.status(404).build();
    }

    @GetMapping("sub11")
    @ResponseBody
    public ResponseEntity sub11() {
        return ResponseEntity.status(500).build();
    }

    @GetMapping("sub12")
    @ResponseBody
    public ResponseEntity sub12() {
        // 200
        return ResponseEntity.ok().build();
    }

    @GetMapping("sub13")
    @ResponseBody
    public ResponseEntity sub13() {
        // 400
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("sub14")
    @ResponseBody
    public ResponseEntity sub14() {
        // 404
        return ResponseEntity.notFound().build();
    }

    @GetMapping("sub15")
    @ResponseBody
    public ResponseEntity sub15() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("sub16")
    @ResponseBody
    public ResponseEntity sub16() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("sub17")
    @ResponseBody
    public ResponseEntity sub17() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("sub18")
    @ResponseBody
    public ResponseEntity sub18() {
        return ResponseEntity.internalServerError().build();
    }

    // 위에는 데이터따로, 응답코드 따로 보냈는데
    // 이제 데이터랑 응답코드 같이 보내봅시다
    @GetMapping("sub19")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sub19() {
        return ResponseEntity.ok().body(
                Map.of("name", "흥민", "address", "런던")
        );
    }

    @GetMapping("sub20")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sub20() {
        return ResponseEntity.badRequest().body(
                Map.of("city", "서울", "text", "hello")
        );
    }

    // 연습 : react 21번째, 22번째 버튼 클릭시 아래 응답 데이터가 콘솔에 출력하도록 코드 완성
    @GetMapping("sub21")
    @ResponseBody
    public ResponseEntity<List<String>> sub21() {
        return ResponseEntity.status(201).body(
                List.of("java", "css", "react")
        );
    }

    @GetMapping("sub22")
    @ResponseBody
    public ResponseEntity<List<String>> sub22() {
        return ResponseEntity.status(500).body(
                List.of("apple", "lemon", "mango")
        );
    }

    @GetMapping("sub23")
    @ResponseBody
    public ResponseEntity<List<String>> sub23() {
        if (Math.random() < (1.0 / 3)) {
            return ResponseEntity.status(400).build();
        } else if (Math.random() < (2.0 / 3)) {
            return ResponseEntity.status(500).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }
}
