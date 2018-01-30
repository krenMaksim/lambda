package com.kren.chapter3;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<String> list = new ArrayList<>();
    static {
	list.add("");
	list.add("fdfdsfd");
	list.add("");
    }

    public static void main(String[] args) {

	long count = list.stream()
			 .filter((name) -> {

			     System.out.println(name);

			     return name.isEmpty();
			 })
			 .count();

	System.out.println(count);
    }

    public static void t(int f, int d, int g, int ddfds) {

    }

}
