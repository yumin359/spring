package com.example.spring.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.spring.entity.Entity38}
 */
@Value
public class Entity38Dto implements Serializable {
    Integer id;
    String title;
    String content;
    String authorEmail; // flat하게 만들어짐
    //    String author; // 전체 했으면 이렇게 됐을 거
    LocalDateTime insertedAt;
}