package com.kren.logicbig;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TerminalShortCircuiting {

    public static void main(String[] args) {
	findFirstStream();
    }

    static void findFirstStream() {
	// how create int array
	IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	OptionalInt optionalInt = intStream.filter(i -> i % 100 == 0)
					   .findFirst();

	if (optionalInt.isPresent()) {
	    System.out.println(optionalInt.getAsInt());
	}

	System.err.println(optionalInt.isPresent());

    }

}
