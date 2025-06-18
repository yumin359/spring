package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity25Id implements Serializable {
    private static final long serialVersionUID = 4558611942778632418L;
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity25Id entity = (Entity25Id) o;
        return Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name);
    }

}