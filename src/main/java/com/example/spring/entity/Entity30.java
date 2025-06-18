package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table30", schema = "jpa")
public class Entity30 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "info", length = 20)
    private String info;

    @ManyToOne//(fetch = FetchType.LAZY) // 여기에 대한 내용은 sub9
    @JoinColumn(name = "employee_id")
    private Entity29 employee;
    // 강사님은 주로 지워서 쓰신다는데 일단 우리가 하는데에서는 문제가 크진 않다나봐여 흠 자세한 건 내일 더 한대요
}