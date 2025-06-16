package com.example.spring.controller;

import com.example.spring.entity.Entity14;
import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor // 생성자 자동 생성
public class Controller20 {
    // 그래서 이렇게만 해도 자동으로 생성자 만들어줌
    private final Service2 service2;

    @GetMapping("sub1")
    public String sub1() {
        service2.process1();

        return "/main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service2.process2();
        return "/main20/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service2.process3();
        return "/main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4() {
        service2.process4();
        return "/main20/sub4";
    }

    @GetMapping("sub5")
    public String sub5() {
        service2.process5();
        return "/main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6() {
        service2.process6();
        return "/main20/sub6";
    }


    @GetMapping("sub10")
    public String sub10() {
        // Spring Data JPA
        // Entity : 테이블과 매핑되는 클래스(객체)
        // Repository : Entity를 이용한 CRUD 메소드를 제공하는 클래스 또는 인터페이스
        //// SELECT : find... , get...
        //// UPDATE : save
        //// DELETE : delete...
        //// INSERT : save

        //// JpaRepository<T,ID> 인터페이스를 상속해서 만들면 됨
        //// 타입파라미터 T : crud 대상 테이블의 매핑되는 Entity
        //// 타입파라미터 ID : Entity의 PK의 자료형

        //// Spring은
        //// Repository 인터페이스에 있는 메소드를 활용해서
        //// 연결, statement, ResultSet 처리하는 구현 코드를 생성.
        // db연결
        // statement
        // 쿼리실행
        // result set 처리
        // Entity10타입의 객체리턴

        service2.process7();
        return "/main20/sub10";
    }

    @GetMapping("sub11")
    public String sub11() {
        service2.process8();
        return "/main20/sub11";
    }
    // table---마우스 달칵해서 만드는 거 있음--->entity---플러그인?으로 한대여--->repository

    @GetMapping("sub12")
    public String sub12() {
        service2.process9();
        return "/main20/sub12";
    }

    // 연습
    // Entity13 만들고
    // Entity13Repository 만들기
    // request handler method, service.process10() 메소드
    // 만들어서 findById() 호출해보기 // 테이블 없다는 에러 보기
    @GetMapping("sub13")
    public String sub13() {
        service2.process10();
        return "/main20/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id, Model model) {
        Entity14 data = service2.process11(id);

        model.addAttribute("data", data);
        System.out.println(data);
        return "/main20/sub14";
    }

    // /main20/sub15?name=cho&score=88.8&city=seoul
    @GetMapping("sub15")
    public String sub15(String name, Double score, String city) {
        service2.process12(name, score, city);
        return "/main20/sub15";
    }

    // /main20/sub16?address=신촌&price=5678&insertedAt=2010-10-10T12:13:14
    // /main20/sub16?address=busan&price=1000&insertedAt=1999-09-09T12:13:14
    @GetMapping("sub16")
    public String sub16(String address, Integer price, LocalDateTime insertedAt) {
        service2.process13(address, price, insertedAt);
        return "/main20/sub16";
    }

    // /main20/sub17?id=2&score=12.34
    @GetMapping("sub17")
    public String sub17(Integer id, Double score) {
        service2.process14(id, score);
        return "/main20/sub17";
    }

    // 연습
    // /main20/sub18?id=1&address=강남
    // 으로 요청시 15번 테이블의 1번 키의 레코드의 address 값을 강남으로 바꾸는 코드 작성
    @GetMapping("sub18")
    public String sub18(Integer id, String address) {
        service2.process15(id, address);
        return "/main20/sub18";
    }

    // /main20/sub19?id=1
    @GetMapping("sub19")
    public String sub19(Integer id) {
        service2.process16(id);
        return "/main20/sub19";
    }

    // 연습
    // /main20/sub20?id=1
    // 15번 테이블 1번 레코드 삭제 코드 작성
    @GetMapping("sub20")
    public String sub20(Integer id) {
        service2.process17(id);
        return "/main20/sub20";
    }

}
