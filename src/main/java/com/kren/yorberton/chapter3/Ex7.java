package com.kren.yorberton.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex7 {

    private static List<String> strings = Arrays.asList("fdsfds", "/                /", "DFDSSFD");

    public static void main(String[] args) {

	Optional<String> optionalStr = strings.stream()
					      .max((a, b) -> countLoverCaseCharacters(a) - countLoverCaseCharacters(b));

	if (optionalStr.isPresent()) {
	    System.out.println(optionalStr.get());
	}

    }

    static int countLoverCaseCharacters(String str) {
	return (int) str.chars()
			.filter(Character::isLowerCase)
			.count();
    }

}
