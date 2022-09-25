package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        for (int i = 0; i <=10; i++) {
            System.out.println(i);
        }
        //exclusive 0*1*2*3*4*5*6*7*8*9
        IntStream.range(0,10)
                .forEach(index -> System.out.println(index));
        //inclusive 0*1*2*3*4*5*6*7*8*9*10
        IntStream.rangeClosed(0,10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        //if I need an Index
        IntStream.range(0,people.size())
                .forEach(index ->{
                    Person person = people.get(index);
                    System.out.println(person);
                } );

        //If no Index needed
        people.forEach(System.out::println);
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0,operand -> operand +1)
                .filter(number -> number % 2 ==0 ) // juste les paire par exemple
                .limit(20)
                .forEach(System.out::println);
    }
}
