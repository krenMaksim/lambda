package com.kren.yorberton.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example5dot8 {

    public static void main(String[] args) {
	List<Integer> listInt = Arrays.asList(3, 2, 12, 5, 6, 11, 13);

	Map<Boolean, List<Integer>> map = listInt.stream()
						 .collect(Collectors.partitioningBy(digit -> digit % 2 == 0));

	System.out.println(map);

    }

}
