package com.hong.eatgo.interfaces;

import com.hong.eatgo.application.RegionService;
import com.hong.eatgo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Category> list() {
        List<Category> regions = regionService.getRegions();


        return regions;
    }
}
