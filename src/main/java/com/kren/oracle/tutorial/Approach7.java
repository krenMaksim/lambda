package com.kren.oracle.tutorial;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Approach7 {

    public static void main(String[] args) {
	Predicate<Person> tester = p -> 18 <= p.getAge() && p.getAge() < 25;
	Consumer<Person> printOutPut = p -> p.printPerson();

	processPersons(Person.roster, tester, printOutPut);
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> printOutPut) {
	for (Person person : roster) {
	    if (tester.test(person)) {
		printOutPut.accept(person);
	    }
	}
    }

}
