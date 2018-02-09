package com.kren.oracle.tutorial;

import java.util.List;

public class Approach1 {

    public static void main(String[] args) {
	printPersonsOlderThan(Person.roster, 20);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
	for (Person p : roster) {
	    if (p.getAge() >= age) {
		p.printPerson();
	    }
	}
    }

}
