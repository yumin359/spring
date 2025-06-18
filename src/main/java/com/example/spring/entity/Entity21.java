package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table21", schema = "jpa")
@ToString
public class Entity21 {
    @Id // PK는 얘 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가(AUTO_INCREMENT) 아니면 이거 안 써도 됨
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "inserted_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime insertedAt;
    // insertable = false, updatable = false 두 개 잘 써서 활용하기

}