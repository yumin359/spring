package com.example.spring.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.spring.entity.Entity37}
 */
@Value
public class Entity37Dto implements Serializable {
    String email;
    String info;
    LocalDateTime insertedAt;
    //  필요한 정보만 쓰면 됨 여기선 password 안 가져옴
}