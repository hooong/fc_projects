package com.hong.eatgo.application;

import com.hong.eatgo.domain.Category;
import com.hong.eatgo.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Category> getRegions() {
        return regionRepository.findAll();
    }

    public Category addRegion(String name) {
        Category region = Category.builder().name(name).build();

        regionRepository.save(region);

        return region;
    }
}
