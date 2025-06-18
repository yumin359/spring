package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity20;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity20Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
// 둘 중에 아무거나 써도 되지만 별 일 없으면 바로 아래 거로 쓰세용
import org.springframework.transaction.annotation.Transactional;
//import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {

    private final Entity16Repository entity16Repository;
    private final Entity20Repository entity20Repository;
    private final Entity18Repository entity18Repository;

    public void action1(Integer page) {
        // repository 사용
        Page<Entity16> pageContent = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);
    }

    public void action2(String country) {
        List<Entity16> list = entity16Repository.findByCountry(country);
        list.forEach(System.out::println);
    }

    // 쿼리 메소드와 페이징
    public void action3(String country, Integer page) {
        Page<Entity16> pageContent = entity16Repository
                .findByCountry(country,
                        PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);
    }

    public void action4(String keyword, Integer page) {
        // SELECT * FROM customer
        // WHERE customer_name LIKE '%ed%' OR contact_name LIKE '%ed%'
        Page<Entity16> pageContent = entity16Repository
                .findByCustomerNameContainsOrContactNameContains(keyword, keyword,
                        PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);
    }

    public void action5(Integer id) {
        entity16Repository.deleteById(id);
    }

    // 이거 안 붙여주면 레코드들 못 지워줌
    // 지우다가 익셉션 일어나면 모두 롤백처리 해줘야해서? 아무튼 이거 필요하다네용 .,.
    @Transactional
    public void action6(String country) {
        entity16Repository.deleteByCountry(country);
    }

    public void action7() {
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        // a만 commit 됨
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }

        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional // 이거 있으면 중간에 Exception 나면 rollback 처리해줌
    public void action8() {
        // 보통 service의 하나의 메소드가 하나의 transaction 임
        // -> @Transactional 어노테이션을 service의 모든 메소드에 붙여야 함.
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }

        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);
    }

    @Transactional
    public void action10(String country) {
        // select 후 하나씩 지움 : 성능 이슈 있음
//        entity16Repository.deleteByCountry(country);

        // -> JPQL 이나 SQL로 직접 작성해서 지워야함
        entity16Repository.bulkDeleteByCountry(country);
        // 메소드명은 상관 없음
    }

    @Transactional
    public void action11(String country) {
        entity18Repository.totaldelete(country);
    }

    @Transactional
    public void action12(String country) {
        // update, delete, insert

        // rollback 됨
        // throw new RuntimeException();

        // update, delete, insert
    }

    @Transactional // -> RuntimeException에만 반응함
    public void action13(String country) {
        // update, delete, insert

        // rollback 안 됨
        // throw new Exception();

        // update, delete, insert
    }


    @Transactional // 그래서 체크드 익셉션 발생하면 런타임 익셉션으로 바꿔서 해줌. 이런 일이 종종 일어나여
    public void action14(String country) {
        // update, delete, insert

        // rollback 됨
        // throw new Exception();
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // update, delete, insert
    }
    // 지금까진 메소드마다 트랜잭셔널 붙였는데 앞으로는 서비스클래스에다가 붙일거에용
    

}
