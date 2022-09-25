package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        Predicate<Car> filter = car -> car.getPrice() < 15000;

        List<Car> carsFiltered = cars.stream()
                .filter(car -> car.getPrice() > 1000)
                .filter(filter)
                .toList();

        carsFiltered.forEach(System.out::println);

        System.out.println(carsFiltered.size());
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }
    IntPredicate lessthan10 = number -> number < 10;
    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        int first = Arrays.stream(numbers)
                .filter(lessthan10)
                .findFirst()
                .getAsInt();

        System.out.println(first);
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int any = Arrays.stream(numbers)
                .filter(lessthan10)
                .findAny()
                .getAsInt();

        System.out.println(any);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even).
                allMatch(value -> value < 11);

        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).
                anyMatch(value -> value > 10);

        System.out.println(anyMatch);
    }

}



