package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();

        long redcount = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Red"))
                .count();

        System.out.println(redcount);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();

        double min =MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .min()
                .getAsDouble();

        System.out.println(min);

    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double max =MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .max()
                .getAsDouble();

        System.out.println(max);

    }

    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();

        //List Vide ça nous donne false comme réponse
        //ImmutableList<Car> cars =ImmutableList.of();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElseThrow();

        System.out.println(average);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();

        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();

        System.out.println(sum);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println(doubleSummaryStatistics);
    }

}