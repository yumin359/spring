package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "my_table23", schema = "jpa")
public class Entity23 {
    @EmbeddedId
    private Entity23Id id;
    // 두개의 PK를 한번에 가져옴

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "info", length = 30)
    private String info;

}

// Entity23~Entity26까지가 두개의 PK에 관한 내용->컨트롤러랑 서비스 없움 Entity, EntityId들만 보면 됨
// Entity27~Entity30까지는 FK에 관한 내용->Controller25, Service7