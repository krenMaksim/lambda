package com.kren.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {

    public static void main(String[] args) {

	List<String> collected = Stream.of("a", "b", "hello")
				       .map(string -> string.toUpperCase())
				       .collect(Collectors.toList());

	System.out.println(collected);
    }

}
