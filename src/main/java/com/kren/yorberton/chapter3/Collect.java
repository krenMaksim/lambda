package com.kren.yorberton.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {

	List<String> collected = Stream.of("a", "b", "wwwwww", "c")
				       .collect(Collectors.toList());

	System.out.println(collected);
    }

}
