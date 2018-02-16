package com.kren.oracle.tutorial;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReferences {

    public static void main(String[] args) {

	Person[] roster = Person.roster.toArray(new Person[Person.roster.size()]);

	System.out.println(Arrays.toString(roster));

	// way one
	Arrays.sort(roster, new PersonAgeComparator());

	System.out.println(Arrays.toString(roster));

	// way two
	Arrays.sort(roster, (firstPerson, secondPerson) -> firstPerson.getAge() - secondPerson.getAge());

	System.out.println(Arrays.toString(roster));

	// way three
	Arrays.sort(roster, Person::compareByAge);

	System.out.println(Arrays.toString(roster));

	// way four
	PersonAgeComparator ageComparator = new PersonAgeComparator();

	Arrays.sort(roster, ageComparator::compare);

	System.out.println(Arrays.toString(roster));

    }

    private static class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person first, Person second) {
	    return first.getAge() - second.getAge();
	}

    }

}
