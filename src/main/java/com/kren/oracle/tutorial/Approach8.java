package com.kren.oracle.tutorial;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Approach8 {

    public static void main(String[] args) {
	Iterable<Person> roster = Person.roster;
	Predicate<Person> tester = p -> 18 <= p.getAge() && p.getAge() < 25;
	Function<Person, String> mapper = p -> p.getEmailAddress();
	Consumer<String> printOutPut = email -> System.out.println(email);

	processElements(roster, tester, mapper, printOutPut);
    }

    public static <X, Y> void processElements(Iterable<X> roster, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> printOutPut) {
	for (X item : roster) {
	    if (tester.test(item)) {
		Y rezult = mapper.apply(item);
		printOutPut.accept(rezult);
	    }
	}
    }

}
