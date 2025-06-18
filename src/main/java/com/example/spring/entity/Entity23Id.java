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
public class Entity23Id implements Serializable {
    private static final long serialVersionUID = -8112836605159795988L; // 있어도 되고 없어도 되고
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "address", nullable = false, length = 30)
    private String address;


    // 얘네는 객체가 참조값이 달라도 같은 값을 가짐다
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity23Id entity = (Entity23Id) o;
        return Objects.equals(this.address, entity.address) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }

}