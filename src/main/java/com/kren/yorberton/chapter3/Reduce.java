package com.kren.yorberton.chapter3;

import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {

	int sum = Stream.of(1, 2, 3)
			.reduce(0, (acc, element) -> acc + element);

	System.out.println(sum);

	int mult = Stream.of(1, 2, 3, 4)
			 .reduce(1, (acc, element) -> acc * element);

	System.out.println(mult);

	// reduce with filter
	int filteredSum = Stream.of(1, 2, 3)
				.filter(i -> i % 2 == 0)
				.reduce(0, (acc, element) -> acc + element);

	System.out.println(filteredSum);

    }

}
