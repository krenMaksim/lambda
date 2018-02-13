package com.kren.oracle.tutorial;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Approach9 {

    public static void main(String[] args) {
	Predicate<Person> tester = p -> 18 <= p.getAge() && p.getAge() < 25;
	Function<Person, String> mapper = p -> p.getEmailAddress();
	Consumer<String> printOutPut = email -> System.out.println(email);

	List<Person> roster = Person.roster;

	roster.stream()
	      .filter(tester)
	      .map(mapper)
	      .forEachOrdered(printOutPut);

    }

}
