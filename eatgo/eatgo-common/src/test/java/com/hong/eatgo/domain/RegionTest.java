package com.hong.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RegionTest {

    @Test
    public void creation() {
        Category region = Category.builder().name("서울").build();

        assertThat(region.getName(), is("서울"));
    }

}