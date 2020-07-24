package com.hong.eatgo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    List<Restaurant> findAllByAddressContainingAndCategoryId(
            String seoul, Long categoryId);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);
}