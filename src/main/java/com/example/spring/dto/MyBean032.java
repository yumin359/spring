package com.example.spring.dto;

public class MyBean032 {
    private String name;
    private String company;
    private String home;
    private Integer age;

    @Override
    public String toString() {
        return "MyBean032{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", home='" + home + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getHome() {
        return home;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
