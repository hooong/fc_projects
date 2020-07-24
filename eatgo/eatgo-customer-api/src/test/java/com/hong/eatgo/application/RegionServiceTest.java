package com.hong.eatgo.application;

import com.hong.eatgo.domain.Category;
import com.hong.eatgo.domain.RegionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class RegionServiceTest {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);

        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions(){
        List<Category> mockregions = new ArrayList<>();
        mockregions.add(Category.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mockregions);

        List<Category> regions = regionService.getRegions();
        Category region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }

}