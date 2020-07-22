package com.hong.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellcomeController {

    @GetMapping("/")
    public String hello() {
        return "hello, world";
    }
}
