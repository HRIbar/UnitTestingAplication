package com.udemy.unittesting.unittesting.spike;

import org.junit.Test;

import static  org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;


public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(X -> X > 10)
                .allMatch(X -> X < 100)
                .noneMatch(X -> X < 0);

        assertThat("").isEmpty();
        assertThat("ABCDE").endsWith("CDE");

    }


}
