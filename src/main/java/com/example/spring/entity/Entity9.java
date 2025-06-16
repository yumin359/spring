package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "my_table9")
public class Entity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double salary;
    private LocalDateTime birthday;
    private String info;
}
// 완벽하게 만들어주는건 아니니 필요에 맞게 수정하면 됨