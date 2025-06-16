package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table3")
@Getter
@Setter
@ToString
public class Entity3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 클래스의 필드명과 테이블의 컬럼명이 같으면 @Column 생략 가능
//    @Column(name = "email")
    private String email;
    //    @Column(name = "info")
    private String info;
    //    @Column(name = "nick")
    private String nick;
    private String country;

    // java 변수명 관습 : lowerCamelCase
    // 따라서 둘은 이름이 달라서 이거 써줘야함
//    @Column(name = "home_address")
    // 근데 없어도 매치 해준대여
    private String homeAddress;

    // 연습
    // work_address 테이블컬럼에 매핑되는
    // java field 작성하기
    // @Column 안 해도 잘 매핑 되네영
    private String workAddress;
}
