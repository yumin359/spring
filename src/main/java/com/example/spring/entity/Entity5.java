package com.example.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table5")
@Getter
@Setter
@ToString
public class Entity5 {
    @Id
    private Integer id;
    private String address;
    private LocalDate hiredDate;
    private LocalDateTime insertedAt;
    private Double height;
    private Integer score;
}
