package com.hong.eatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {

    @Id @GeneratedValue
    private Long id;

    private Long restaurantId;

    private final String name;

    public String getName() {
        return name;
    }

    public MenuItem(String name) {
        this.name = name;
    }
}
