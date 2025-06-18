package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repository.Entity27Repository;
import com.example.spring.repository.Entity28Repository;
import com.example.spring.repository.Entity29Repository;
import com.example.spring.repository.Entity30Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {


    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;
    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

    public void action1() {
        Entity27 c1 = new Entity27();
        Entity27 c2 = new Entity27();
        Entity27 c3 = new Entity27();

        c1.setCategoryName("음료수");
        c1.setInfo("설탕물");

        c2.setCategoryName("전자제품");
        c2.setInfo("전기를 사용하는 물건");

        c3.setCategoryName("청소용품");
        c3.setInfo("청소할 때 필요해");

        entity27Repository.save(c1);
        entity27Repository.save(c2);
        entity27Repository.save(c3);


    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1장");
        p6.setUnit("1대");

        Entity27 c1 = entity27Repository.findById(1).get();
        Entity27 c2 = entity27Repository.findById(2).get();
        Entity27 c3 = entity27Repository.findById(3).get();

        p1.setCategory(c3);
        p2.setCategory(c2);
        p3.setCategory(c1);
        p4.setCategory(c1);
        p5.setCategory(c3);
        p6.setCategory(c2);

        entity28Repository.save(p1);
        entity28Repository.save(p2);
        entity28Repository.save(p3);
        entity28Repository.save(p4);
        entity28Repository.save(p5);
        entity28Repository.save(p6);

    }

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);
    }

    public void action4(Integer id) { // -> 상품 정보와 카테고리 정보 조인이 일어나며 모든 정보가 출력됨 // 부모 테이블도 조회됨
        Entity28 entity28 = entity28Repository.findById(id).get();
        System.out.println("entity28 = " + entity28);
    }

    // 직원 정보 입력
    public void action5() {
        Entity29 e1 = new Entity29();
        Entity29 e2 = new Entity29();
        Entity29 e3 = new Entity29();

        e1.setFirstName("kim");
        e1.setLastName("kkk");
        e1.setBirthDate(LocalDate.of(1998, 3, 5));
//        e1.setBirthDate(LocalDate.parse("1998-03-05")); // 강사님은 이렇게 하심

        e2.setFirstName("lee");
        e2.setLastName("lll");
        e2.setBirthDate(LocalDate.of(2000, 6, 13));

        e3.setFirstName("cho");
        e3.setLastName("ccc");
        e3.setBirthDate(LocalDate.of(2002, 11, 20));

//        entity29Repository.saveAll(List.of(e1, e2, e3)); // 강사님은 이렇게 하심
        entity29Repository.save(e1);
        entity29Repository.save(e2);
        entity29Repository.save(e3);
    }

    // 상품 정보 입력
    public void action6() {
        Entity30 op1 = new Entity30();
        Entity30 op2 = new Entity30();
        Entity30 op3 = new Entity30();
        Entity30 op4 = new Entity30();
        Entity30 op5 = new Entity30();
        Entity30 op6 = new Entity30();

        op1.setOrderDate(LocalDate.of(2020, 2, 2));
        op2.setOrderDate(LocalDate.of(2021, 4, 8));
        op3.setOrderDate(LocalDate.of(2022, 6, 14));
        op4.setOrderDate(LocalDate.of(2023, 8, 16));
        op5.setOrderDate(LocalDate.of(2024, 10, 22));
        op6.setOrderDate(LocalDate.of(2025, 12, 28));

        op1.setInfo("kim이 주문 처리");
        op2.setInfo("lee가 주문 처리");
        op3.setInfo("cho가 주문 처리");
        op4.setInfo("kim이 주문 처리");
        op5.setInfo("lee가 주문 처리");
        op6.setInfo("cho가 주문 처리");

        Entity29 oe1 = entity29Repository.findById(1).get();
        Entity29 oe2 = entity29Repository.findById(2).get();
        Entity29 oe3 = entity29Repository.findById(3).get();

        op1.setEmployee(oe1); // kim 이 처리
        op2.setEmployee(oe2); // lee 가 처리
        op3.setEmployee(oe3); // cho 가 처리
        op4.setEmployee(oe1); // kim
        op5.setEmployee(oe2); // lee
        op6.setEmployee(oe3); // cho

//        entity30Repository.saveAll(List.of(op1, op2, op3, op4, op5, op6)); // 강사님이 하신 거
        entity30Repository.save(op1);
        entity30Repository.save(op2);
        entity30Repository.save(op3);
        entity30Repository.save(op4);
        entity30Repository.save(op5);
        entity30Repository.save(op6);
    }

    // 직원 정보 조회
    public void action7(Integer id) {
        Entity29 entity29 = entity29Repository.findById(id).get();
        System.out.println("entity29 = " + entity29);
    }

    // 직원이 처리한 상품들 조회
    public void aciton8(Integer id) {
        Entity30 entity30 = entity30Repository.findById(id).get();
        System.out.println("entity30 = " + entity30);
    }

    // 여까지가 외래키와 Entity

    public void action9(Integer id) {
        Entity30 o = entity30Repository.findById(id).get();

        System.out.println("o.getOrderDate() = " + o.getOrderDate());
        System.out.println("o.getInfo() = " + o.getInfo());
        // LAZY가 있는 상태에서는 30번 테이블만 조회

        // 직원 정보
        // 테이블 29를 이제서야 조회
        System.out.println("o.getEmployee().getLastName() = " + o.getEmployee().getLastName());

        // LAZY를 안 쓰면 조인해서 한꺼번에 조회
        //
    }
}
