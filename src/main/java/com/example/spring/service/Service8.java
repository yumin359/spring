package com.example.spring.service;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.OrderInfo;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import com.example.spring.entity.Entity39;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service8 {

    private final Entity34Repository entity34Repository;
    private final Entity35Repository entity35Repository;
    private final Entity36Repository entity36Repository;
    private final Entity39Repository entity39Repository;
    private final Entity41Repository entity41Repository;

    public void action1() {
        // 학생 정보 입력
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        Entity34 s3 = new Entity34();
        s1.setName("kim");
        s2.setName("lee");
        s3.setName("cho");
        entity34Repository.save(s1);
        entity34Repository.save(s2);
        entity34Repository.save(s3);

        // 강의 정보 입력
        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        Entity35 l3 = new Entity35();
        l1.setLectureTitle("java");
        l2.setLectureTitle("python");
        l3.setLectureTitle("react");
        entity35Repository.save(l1);
        entity35Repository.save(l2);
        entity35Repository.save(l3);

        // 수강 정보 입력
        Entity36 c1 = new Entity36();
        Entity36 c2 = new Entity36();
        Entity36 c3 = new Entity36();
        Entity36 c4 = new Entity36();
        Entity36 c5 = new Entity36();
        Entity36 c6 = new Entity36();
        c1.setRegisteredAt(LocalDate.now());
        c2.setRegisteredAt(LocalDate.now());
        c3.setRegisteredAt(LocalDate.now());
        c4.setRegisteredAt(LocalDate.now());
        c5.setRegisteredAt(LocalDate.now());
        c6.setRegisteredAt(LocalDate.now());

        // 학생 1 -> 강의 1,2
        c1.setStudent(s1);
        c2.setStudent(s1);
        c1.setLecture(l1);
        c2.setLecture(l2);

        // 학생 2 -> 강의 2,3
        c3.setStudent(s2);
        c4.setStudent(s2);
        c3.setLecture(l2);
        c4.setLecture(l3);

        // 학생 3 -> 강의 1,3
        c5.setStudent(s3);
        c6.setStudent(s3);
        c5.setLecture(l1);
        c6.setLecture(l3);

        entity36Repository.saveAll(List.of(c1, c2, c3, c4, c5, c6));
    }

    public void action2() {
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        s1.setName("park");
        s2.setName("shin");
        s1.setBirthDate(LocalDate.parse("2000-01-01"));
        s2.setBirthDate(LocalDate.parse("1998-05-13"));
        s1.setInfo("정보1");
        s2.setInfo("정보2");
        entity34Repository.save(s1);
        entity34Repository.save(s2);

        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        l1.setLectureTitle("html");
        l2.setLectureTitle("spring");
        l1.setInfo("프론트엔드");
        l2.setInfo("백엔드");
        l1.setPlace("seoul");
        l2.setPlace("busan");
        entity35Repository.save(l1);
        entity35Repository.save(l2);

        Entity36 c1 = new Entity36();
        Entity36 c2 = new Entity36();
        c1.setRegisteredAt(LocalDate.now());
        c2.setRegisteredAt(LocalDate.now());
        c1.setLecture(l1);
        c2.setLecture(l2);
        c1.setStudent(s1);
        c2.setStudent(s2);
        entity36Repository.save(c1);
        entity36Repository.save(c2);
    }

    public void action3() {
        // 4번 학생이 수강한 강의 지우기
        entity36Repository.deleteByStudentId(4);
    }

    public void action4() {
        // 5번학생 지우기 -> 이건 안 지워짐
        entity34Repository.deleteById(5);
    }

    public void action5() {
        // 5번학생의 수강정보를 먼저 지워야함
        entity36Repository.deleteByStudentId(5);
        // 5번학생 지우기
        entity34Repository.deleteById(5);
    }

    // 따라서 부모 테이블 지우려면 자식 테이블 먼저 지워야 한다

    public void action6() {
        // 연습
        // 3번 강의 지우기
        entity36Repository.deleteByLectureId(3);
        entity35Repository.deleteById(3);
    }

    public void action7() {
        Entity36 l1 = entity36Repository.findById(1).get();
        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();

        // LAZY일 경우 이 떄 select 쿼리 실행
        String name = s1.getName();// 이렇게 속성에 접근할 때
        System.out.println("name = " + name);
    }


    public Entity36 action8() {
        // Transactional 때문에 얘가 닫혀서 컨트롤러에서 쓸 수 없음
        Entity36 l1 = entity36Repository.findById(1).get();
        return l1;
    }

    public Entity36Dto action9() {
        Entity36 l1 = entity36Repository.findById(1).get();

        Entity36Dto d1 = new Entity36Dto();
        d1.setRegisteredAt(l1.getRegisteredAt());
        d1.setStudentName(l1.getStudent().getName());

        // entity를 리턴하면 안됨
        // -> dto로 값 옮겨 담고 리턴하기
        return d1;
    }

    public List<Entity39Dto> action10() {
        // t39(product), t40(category)
        // 상품번호, 상품명, 가격, 카테고리이름
        List<Entity39> list = entity39Repository.findAll();

        List<Entity39Dto> result = new ArrayList<>();
        for (Entity39 entity39 : list) {
            Entity39Dto d = new Entity39Dto();
            d.setId(entity39.getId());
            d.setName(entity39.getName());
            d.setPrice(entity39.getPrice());
            d.setCategoryName(entity39.getCategory().getName());
            result.add(d);
        }
        return result;
    }

    public List<ProductInfo> action11() {
        // t39(product), t40(category)
        // 상품번호, 상품명, 가격, 카테고리이름
        /*
        SELECT p.id, p.name product_name, p.price, c.name category_name
        FROM t39 p JOIN t40 c p.category_id = c.id
         */
        List<ProductInfo> result = entity39Repository.query1();
        return result;
    }

    public List<OrderInfo> action12() {
        return entity41Repository.query1();
    }
}
