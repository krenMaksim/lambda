package com.kren.oracle.tutorial;

import java.util.List;

public class Approach2 {

    public static void main(String[] args) {
	printPersonsWithinAgeRange(Person.roster, 20, 25);
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
	for (Person p : roster) {
	    if (low <= p.getAge() && p.getAge() < high) {
		p.printPerson();
	    }
	}
    }

}
