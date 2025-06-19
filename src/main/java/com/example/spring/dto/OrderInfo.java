package com.example.spring.dto;

import java.time.LocalDate;

// @ToString 안 됨 ㅎ
public interface OrderInfo {
    // SELECT o.order_date, p.name product_name, p.price, o.quantity, c.name category_name
    LocalDate getOrderDate();

    String getProductName();

    Integer getPrice();

    Integer getQuantity();

    String getCategoryName();
}
