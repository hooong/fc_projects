package com.hong.eatgo.interfaces;

import com.hong.eatgo.domain.Restaurant;
import com.hong.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        return repository.findById(id);
    }
}
