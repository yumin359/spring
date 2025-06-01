package com.example.spring.dto;

// java beans
public class MyBean031 {
    // private fields
    private String name;
    private String address;

    // 파라미터 없는 생성자(기본 생성자)
    // 아무것도 안 하면 자동으로 기본 생성자가 있는 거
//    public MyBean031() {
//    }

    // getters, setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
