package com.hong.eatgo.domain;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);
}
