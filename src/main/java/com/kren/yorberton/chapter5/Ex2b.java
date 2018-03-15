package com.kren.yorberton.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2b {

    // Пусть дан поток, элементы которого – слова. Посчитайте, сколько раз встречается каждое слово.
    // При следующих исодных данных должен быть возвращен такой объект Map :
    // [John 3, Paul 2, George 1] :

    public static void main(String[] args) {
	Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

	Map<String, Long> map = names.collect(Collectors.groupingBy(value -> value, Collectors.counting()));
	System.out.println(map);
    }
}
