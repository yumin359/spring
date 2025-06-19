package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table36")
@Setter
@Getter
@ToString
public class Entity36 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate registeredAt;
    private String enable;
    private String money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Entity34 student; // 이거 이름 studentId로 하면 안 된다옹

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Entity35 lecture; // 이거 이름 lectureId로 하면 안 된다옹
}
