package com.kren.yorberton.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {

	List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
						  .filter(value -> Character.isDigit(value.charAt(0)))
						  .collect(Collectors.toList());

	System.out.println(beginningWithNumbers);
    }
}
