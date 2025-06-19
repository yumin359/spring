package com.example.spring.dto;

public interface ProductInfo {
    // SELECT p.id, p.name product_name, p.price, c.name category_name
    // 별칭으로 만들어짐
    Integer getId();

    String getProductName();

    Integer getPrice();

    String getCategoryName();

}
