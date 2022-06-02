package com.home.prospring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Member> users;

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
