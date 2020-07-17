package com.hong.eatgo.interfaces;

import com.hong.eatgo.application.RestaurantService;
import com.hong.eatgo.domain.MenuItem;
import com.hong.eatgo.domain.MenuItemRepository;
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
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        // 기본 정보 + 메뉴 정보

//        Restaurant restaurant = restaurantRepository.findById(id);

//

        return restaurant;
    }
}
