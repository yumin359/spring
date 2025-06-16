package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table7", schema = "jpa")
public class Entity7 {
    // 엔티티를 간단한 방법으로 만든 엔티티
    // 생략해도 되는 annotation들이 있지만 그냥 내비두겠습니당.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "today_time")
    private LocalDateTime todayTime;

}