package com.kren.logicbig;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntermediateShortCircuiting {

    public static void main(String[] args) {
	// usingLimitOperation();

	getQuieOrderedNumbers();
    }

    static void usingLimitOperation() {
	int[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	Arrays.stream(ints)
	      .filter(i -> i % 2 == 0)
	      .forEach(System.out::println);

	// with limit
	System.out.println("with limit");
	Arrays.stream(ints)
	      .limit(3)
	      .filter(i -> i % 2 == 0)
	      .forEach(System.out::println);
    }

    static void getQuieOrderedNumbers() {
	Stream<Integer> stream = Stream.iterate(1, i -> i + 1);

	stream.limit(50)
	      .forEach(System.out::println);
    }
}
