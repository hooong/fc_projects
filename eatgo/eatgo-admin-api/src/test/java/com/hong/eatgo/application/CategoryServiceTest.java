package com.hong.eatgo.application;

import com.hong.eatgo.domain.Category;
import com.hong.eatgo.domain.CategoryRepository;
import com.hong.eatgo.domain.RegionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getRegions(){
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(Category.builder().name("Korean Food").build());

        given(categoryRepository.findAll()).willReturn(mockCategories);

        List<Category> categories = categoryService.getCategories();
        Category category = categories.get(0);
        assertThat(category.getName(), is("Korean Food"));
    }

    @Test
    public void addRegion() {
        Category category = categoryService.addCategory("Korean Food");

        verify(categoryRepository).save(any());
        assertThat(category.getName(), is("Korean Food"));
    }

}