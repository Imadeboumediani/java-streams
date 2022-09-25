package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        //Depracated to understund
        List<PersonDTO> personDTOS = people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .toList();

        //New method
        List<PersonDTO> personDTOSnew = people.stream()
                //map is static method defined in PersonDTO
                .map(PersonDTO::map)
                .toList();

        personDTOSnew.forEach(System.out::println);

        assertThat(personDTOSnew).hasSize(1000);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double average = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        //general
        int sum = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        //optimised
        int sum2 = Arrays.stream(integers)
                .reduce(0, Integer::sum);

        System.out.println(sum2);
    }
}

