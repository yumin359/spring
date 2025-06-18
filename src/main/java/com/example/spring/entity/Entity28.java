package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table28")
@Getter
@Setter
@ToString
public class Entity28 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private Integer price;
    private String unit;

    // category_id
//    private Integer category_id;
    // 이거 잘 설정해야함.
    @ManyToOne // FK 쪽이 앞에나옴
    @JoinColumn(name = "category_id")
    private Entity27 category;
}
