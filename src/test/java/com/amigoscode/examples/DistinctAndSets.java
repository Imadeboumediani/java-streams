package com.amigoscode.examples;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

    @Test
    public void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        assertThat(distinctNumbers).hasSize(9);
        System.out.println(distinctNumbers);
    }

    @Test
    public void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        //Deprecated
        Set<Integer> distinctNumbers = numbers.stream()
                .collect(Collectors.toSet());

        assertThat(distinctNumbers).hasSize(9);
        System.out.println(distinctNumbers);

        //New Method
        Set<Integer> distinctNumbers2 = new HashSet<>(numbers);

        assertThat(distinctNumbers2).hasSize(9);
        System.out.println(distinctNumbers2);

    }
}
