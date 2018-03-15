package com.kren.yorberton.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    // Ссылки на методы. Вернитесь к главе 3 и попробуйте перепи-
    // сать следующие примеры из нее с помощью ссылок на методы.
    // a. Перевод в верхний регистр.
    // b. Реализация count с помощью reduce .
    // c. Конкатенация списков на основе flatMap .

    public static void main(String[] args) {
	a();
	b();
	c();
    }

    static void a() {
	List<String> collected = Stream.of("a", "b", "hello")
				       .map(String::toUpperCase)
				       .collect(Collectors.toList());

	System.out.println(collected);
    }

    static void b() {
	long count = Stream.of(1, 2, 3)
			   .reduce(0, (acc, element) -> acc + element);

	System.out.println(count);

	count = Stream.of(1, 2, 3)
		      .reduce(0, Ex1::count);

	System.out.println(count);
    }

    static void c() {
	List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				       .flatMap(numbers -> numbers.stream())
				       .collect(Collectors.toList());

	System.out.println(together);

	together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
			 .flatMap(List<Integer>::stream)
			 .collect(Collectors.toList());

	System.out.println(together);
    }

    public static int count(int a, int b) {
	return a + b;
    }

}
