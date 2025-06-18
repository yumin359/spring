package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Entity26Id implements Serializable {
    private String user;
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity26Id that = (Entity26Id) o;
        return Objects.equals(user, that.user) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, id);
    }
}
