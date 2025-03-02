package com.example.hello_spring.domain;

import jakarta.persistence.*;

// JPA 사용시 Entity 등록
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼 명 변경 시
    // @Column(name = "username")
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
