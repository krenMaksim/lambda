package com.kren.oracle.tutorial;

import java.util.List;

public class Approach3 {

    public static void main(String[] args) {
	printPersons(Person.roster, new CheckPersonImpl());
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
	for (Person person : roster) {
	    if (tester.test(person)) {
		person.printPerson();
	    }
	}
    }

    private static interface CheckPerson {
	boolean test(Person p);
    }

    private static class CheckPersonImpl implements CheckPerson {

	@Override
	public boolean test(Person p) {
	    return 18 <= p.getAge() && p.getAge() < 25;
	}

    }

}
