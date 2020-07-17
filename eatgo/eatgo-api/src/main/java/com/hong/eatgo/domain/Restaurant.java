package com.hong.eatgo.domain;

public class Restaurant {
    private final Long id;
    private final String name;
    private final String address;

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Object getAddress() {
        return address;
    }

    public Object getInformation() {
        return name + " in " + address;
    }
}
