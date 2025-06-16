package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table8")
public class Entity8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Double salary;

    private LocalDateTime insertedAt;

    private LocalDate hireDate;
}
// 결론은 엔티티 먼저 만들고 테이블 만들 수 있따
/*

CREATE TABLE my_table8
(
id INT AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(23),
salary DECIMAL(10,2),
inserted_at,
hire_date
);

 */
