package com.kren.oracle.tutorial;

import java.util.List;
import java.util.function.Predicate;

public class Approach6 {

    public static void main(String[] args) {
	Predicate<Person> tester = p -> 18 <= p.getAge() && p.getAge() < 25;

	printPersons(Person.roster, tester);
    }

    public static void printPersons(List<Person> roster, Predicate<Person> tester) {
	for (Person person : roster) {
	    if (tester.test(person)) {
		person.printPerson();
	    }
	}
    }

}
