package com.kren.yorberton.chapter5;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
	String result = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe")
			      .collect(Collectors.joining(", ", "[", "]"));

	System.out.println(result);

	result = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe")
		       .collect(Collectors.joining());

	System.out.println(result);

	result = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe")
		       .collect(Collectors.joining("--"));

	Stream<String> stream = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

	Stream.concat(stream, Stream.of(""));

	System.out.println(result);

	String st = null;

	result = Stream.of(st)
		       .filter(value -> Objects.nonNull(value))
		       .collect(Collectors.joining(", ", "[", "]"));

	System.out.println(result);

    }

}
