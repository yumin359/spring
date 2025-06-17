package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service4 {

    private final Entity16Repository entity16Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        System.out.println("############## 1 page #################");
        // paging
        // 페이지 번호가 0번 부터 시작해서 보기 쉽게 '원하는 페이지 번호 - 1' 을 써준 것
        Page<Entity16> list1 = entity16Repository.findAll(PageRequest.of(1 - 1, 10));
        List<Entity16> data1 = list1.getContent(); // 실제 데이터 리스트를 추출함
        for (Entity16 entity16 : data1) {
            System.out.println(entity16);
        }

        System.out.println("############## 2 page #################");
        List<Entity16> list2 = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list2) {
            System.out.println(entity16);
        }

    }

    public void action2() {
        List<Entity19> list1 = entity19Repository.findAll(PageRequest.of(1 - 1, 7)).getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }
        System.out.println();
        List<Entity19> list2 = entity19Repository.findAll(PageRequest.of(2 - 1, 7)).getContent();
        for (Entity19 entity19 : list2) {
            System.out.println(entity19);
        }
    }

    public void action3() {
        // paging and sort (페이징과 정렬)
        // 아래에선 productName 기준으로 오름차순으로 정렬
        System.out.println("########## 1 page ###########");
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of(1 - 1, 7, Sort.by("productName")))
                .getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }

    }

    public void action4() {
        // 계약자명 기준으로 1페이지 출력하기 (1페이지에 10개 데이터)
        // 역순으로 -> descending() 이거 안 붙이면 오름차순
        System.out.println("########## 1 page ###########");
        List<Entity16> list1 = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("contactName").descending()))
                .getContent();
        for (Entity16 entity16 : list1) {
            System.out.println(entity16);
        }
    }

    public void action5() {
        // 가격 역순으로 10개씩 1페이지 상품 내용 보기
        System.out.println("########## 1 page ###########");
        List<Entity19> list = entity19Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("price").descending()))
                .getContent();
        for (Entity19 entity19 : list) {
            System.out.println(entity19);
        }
    }

    public void action6(Integer page) {
        // 91 record
        // 1~10 page
        System.out.println("########## " + page + " page ###########");
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content1 = page1.getContent();
        int totalPages = page1.getTotalPages(); // 10
        long totalElements = page1.getTotalElements(); // 91

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);

        content1.forEach(entity16 -> System.out.println(entity16));
    }


    public void action7(Integer p) {
        System.out.println("########## " + p + " page ###########");
        Page<Entity19> page = entity19Repository
                .findAll(PageRequest.of(p - 1, 10, Sort.by("price")));
        List<Entity19> content = page.getContent();

        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        // 다음 페이지 존재 여부
        boolean next = page.hasNext();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("next = " + next);

        content.forEach(entity19 -> System.out.println(entity19));

    }
}
