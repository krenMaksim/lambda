package com.kren.yorberton.chapter5;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    private static Map<String, String> map = new HashMap<>();

    static {
	for (int i = 0; i < 100; i++) {
	    String value = i + "";
	    map.put(value, value.hashCode() + "ERERE");
	}
    }

    public static void main(String[] args) {
	Map<String, Integer> mapNew = new HashMap<>();

	map.forEach((key, value) -> mapNew.put(key, value.length()));

	System.out.println(mapNew);

	Map<String, String> mapNewTwo = new HashMap<>();
	map.forEach((key, value) -> mapNewTwo.put(key, value.toLowerCase()));

	System.out.println(mapNewTwo);

	// how show map
	map.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));

	// how show map version two
	map.forEach((key, value) -> {
	    System.out.println("key: " + key);
	    System.out.println("value: " + value);
	});
    }

}
