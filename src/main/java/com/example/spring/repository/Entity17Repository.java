package com.example.spring.repository;

import com.example.spring.entity.Entity17;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Entity17Repository extends JpaRepository<Entity17, Integer> {
    @Query(value = """
            SELECT * 
            FROM employee 
            WHERE birth_date BETWEEN :start AND :end
            """, nativeQuery = true)
    List<Entity17> query1(LocalDate start, LocalDate end);

    @Query(value = """
            SELECT *
            FROM employee
            WHERE last_name LIKE :keyword
            OR first_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity17> query2(String keyword);

    @Query(value = """
            SELECT m
            FROM Entity17 m
            WHERE m.lastName LIKE :keyword
            OR m.firstName LIKE :keyword
            """)
    List<Entity17> query3(String keyword);

    //    List<Entity17> query3(@Param("keyword") String keyword); // 권장되긴 하지만 여기선 안쓸게여
    List<Entity17> findByBirthDateBetween(LocalDate start, LocalDate end);
}