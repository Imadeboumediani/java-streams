package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

        StringBuilder join = new StringBuilder();
        for (String name : names){
            join.append(name).append(",");
        }

        System.out.println(join.substring(0,join.length()-2));
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

        String join = String.join(",", names);

        System.out.println(join);

        String join2 = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        System.out.println(join2);
    }

}
