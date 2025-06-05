package com.example.spring.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private Integer supplierId;
    private Integer categoryId;
    private String unit;
    private Double price;
}
