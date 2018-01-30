package com.kren.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {

	List<Integer> listOne = Arrays.asList(1, 2);
	List<Integer> listTwo = Arrays.asList(3, 4);

	List<Integer> together = Stream.of(listOne, listTwo)
				       .flatMap(numbers -> numbers.stream())
				       .collect(Collectors.toList());

	System.out.println(together);
    }

}
