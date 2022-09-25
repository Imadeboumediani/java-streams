package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer min = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();

        assertThat(min).isEqualTo(1);
        System.out.println(min);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();

        assertThat(max).isEqualTo(100);
        System.out.println(100);
    }
}
