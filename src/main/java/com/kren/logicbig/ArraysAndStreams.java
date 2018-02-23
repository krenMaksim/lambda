package com.kren.logicbig;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysAndStreams {

    public static void main(String[] args) {

	int[] ints = { 1, 2, 3 };

	// or

	@SuppressWarnings("unused")
	List<Integer> listInt = Arrays.asList(3, 2, 12, 5, 6, 11, 13);

	int max = Arrays.stream(ints)
			.max()
			.getAsInt();

	System.out.println(max);

	IntStream stream = Arrays.stream(ints);

	List<String> stringInt = stream.mapToObj(value -> String.valueOf(value))
				       .collect(Collectors.toList());

	stringInt.forEach((value) -> System.out.print(" " + value));

	// using random
	new Random().ints(55)
		    .forEach(System.out::println);

    }

}
