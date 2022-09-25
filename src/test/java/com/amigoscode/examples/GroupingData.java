package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();

        //Une Map avec string qui sera le nom de la marque & qui contiendera une liste de Voitures
        Map<String, List<Car>> grouping = cars.stream()
                .collect(Collectors.groupingBy(Car::getMake));


        grouping.forEach((make, carList) -> {
            System.out.println(make);
            carList.forEach(System.out::println);
        });




    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> counting = names.stream()

                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counting.forEach((name, count) -> System.out.println(name+ "=" + count) );
    }

}