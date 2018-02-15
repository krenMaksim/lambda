package com.kren.oracle.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReferenceToInstanceMethod1 {

    public static void main(String[] args) {

	List<Person> persons = Person.roster;

	// variant one
	List<Integer> allAges = listAllAges(persons, Person::getAge);
	System.out.println("Printing out all ages \n" + allAges);

	// variant two
	allAges = listAllAges(persons, x -> x.getAge());
	System.out.println("Printing out all ages \n" + allAges);

	// variant one
	double average = persons.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();

	System.out.println(" \n" + average);

	// variant two
	average = persons.stream()
			 .filter(p -> p.getGender() == Person.Sex.MALE)
			 .mapToInt(p -> p.getAge())
			 .average()
			 .getAsDouble();
	System.out.println(" \n" + average);

	List<Integer> newListAges = new ArrayList<>();
	// simple using
	allAges.forEach(item -> {
	    item++;
	    newListAges.add(item);
	});

	System.out.println(newListAges);

    }

    private static List<Integer> listAllAges(List<Person> person, Function<Person, Integer> f) {
	List<Integer> result = new ArrayList<>();
	person.forEach(x -> result.add(f.apply(x)));
	return result;
    }
}
