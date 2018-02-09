package com.kren.oracle.tutorial;

import java.util.List;

public class Approach5 {

    public static void main(String[] args) {
	CheckPerson tester = p -> 18 <= p.getAge() && p.getAge() < 25;

	printPersons(Person.roster, tester);
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
	for (Person person : roster) {
	    if (tester.test(person)) {
		person.printPerson();
	    }
	}
    }

    @FunctionalInterface
    private static interface CheckPerson {
	boolean test(Person p);
    }

}
