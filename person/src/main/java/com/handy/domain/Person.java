package com.handy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by handy18970 on 2018/3/8.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

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
