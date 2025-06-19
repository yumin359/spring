package com.example.spring.controller;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.OrderInfo;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity36;
import com.example.spring.service.Service8;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main26")
public class Controller26 {

    private final Service8 service8;

    @RequestMapping("sub1")
    public String sub1() {
        service8.action1();
        return "main26/sub1";
    }

    @RequestMapping("sub2")
    public String sub2() {
        // 연습

        // 두 명의 학생 (2개 레코드)
        // 두 개의 강의 (2개 lecture)
        // 각 학생이 하나의 강의 수강 (2개 수강정보)
        service8.action2();
        return "main26/sub2";
    }

    @RequestMapping("sub3")
    public String sub3() {
        service8.action3();
        return "main26/sub3";
    }

    @RequestMapping("sub4")
    public String sub4() {
        service8.action4();

        return "main26/sub4";
    }

    @RequestMapping("sub5")
    public String sub5() {
        service8.action5();

        return "main26/sub5";
    }

    @RequestMapping("sub6")
    public String sub6() {
        service8.action6();
        return "main26/sub6";
    }

    @RequestMapping("sub7")
    public String sub7() {
        service8.action7();
        return "main26/sub7";
    }

    @RequestMapping("sub8")
    public String sub8() {
        Entity36 l1 = service8.action8();
        // 그래서 l1을 model에 넣고 view로 네?

        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();

        // LAZY일 경우 이 떄 select 쿼리 실행
        String name = s1.getName();// 이렇게 속성에 접근할 때
        // session이 닫혀서 exception 발생
        System.out.println("name = " + name);
        // 그래서 Entity로 리턴하면 안 됨
        // -> dto로 옮겨담고 리턴하기 -> sub9

        return "main26/sub8";
    }

    @RequestMapping("sub9")
    public String sub9() {
        Entity36Dto l1 = service8.action9();

        System.out.println(l1.getRegisteredAt());
        System.out.println("name = " + l1.getStudentName());

        return "main26/sub9";
    }

    @RequestMapping("sub10")
    public String sub10() {
        List<Entity39Dto> result = service8.action10();

        for (Entity39Dto dto : result) {
            System.out.println(dto);
        }
        // model에 넣고
        // forward

        return "main26/sub10";
    }

    @RequestMapping("sub11")
    public String sub11() {
        List<ProductInfo> result = service8.action11();

        for (ProductInfo productInfo : result) {
            System.out.println("productInfo.getId() = " + productInfo.getId());
            System.out.println("productInfo.getProductName() = " + productInfo.getProductName());
            System.out.println("productInfo.getPrice() = " + productInfo.getPrice());
            System.out.println("productInfo.getCategoryName() = " + productInfo.getCategoryName());
            System.out.println();
        }
        // model에 넣고
        // forward

        return "main26/sub11";
    }

    @RequestMapping("sub12")
    public String sub12() {
        List<OrderInfo> result = service8.action12();

        for (OrderInfo orderInfo : result) {
            System.out.println("orderInfo.getOrderDate() = " + orderInfo.getOrderDate());
            System.out.println("orderInfo.getProductName() = " + orderInfo.getProductName());
            System.out.println("orderInfo.getPrice() = " + orderInfo.getPrice());
            System.out.println("orderInfo.getQuantity() = " + orderInfo.getQuantity());
            System.out.println("orderInfo.getCategoryName() = " + orderInfo.getCategoryName());
            System.out.println();
        }
        return "main26/sub12";
    }

}
