package com.example.spring.repository;

import com.example.spring.entity.Entity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1Repository extends JpaRepository<Entity1, Integer> { // <객체타입, PK타입>
    // find...
    // save
    // delete
    // 등의 메소드 들을 선언하지 않아도 쓸 수 있음
}
