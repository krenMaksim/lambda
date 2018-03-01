package com.kren.yorberton.chapter3;

public class Ex6 {
    private static final String EXAMPLE = "DFD df    trf       F";

    public static void main(String[] args) {

	long count = EXAMPLE.chars()
			    .filter(ch -> Character.isLowerCase(ch) && Character.isAlphabetic(ch))
			    .count();

	System.out.println(count);

    }

}
