package com.example.spring.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.spring.entity.Entity35}
 */
@Value
public class Entity35Dto implements Serializable {
    Integer id;
    String lectureTitle;
    String info;
    String place;
}
// 만들어진거 그대로 써도 되고 필요하면 getter, setter 등 추가해서 쓰면 됨