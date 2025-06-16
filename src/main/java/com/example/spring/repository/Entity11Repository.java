package com.example.spring.repository;

import com.example.spring.entity.Entity11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository // 생략가능이라 보통 안 쓴대여
public interface Entity11Repository extends JpaRepository<Entity11, Integer> {
}
