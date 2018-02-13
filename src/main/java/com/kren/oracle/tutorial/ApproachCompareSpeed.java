package com.kren.oracle.tutorial;

import java.util.List;

public class ApproachCompareSpeed {

    public static void main(String[] args) {

	List<Person> roster = Person.roster;

	long startWithoutLambda = System.currentTimeMillis();

	withoutLambda(roster);

	long finishWithoutLambda = System.currentTimeMillis();

	withLambda(roster);

	long finishWithLambda = System.currentTimeMillis();

	System.out.println("withoutLambda:" + (finishWithoutLambda - startWithoutLambda));
	System.out.println("withLambda:" + (finishWithLambda - finishWithoutLambda));
    }

    private static void withLambda(List<Person> roster) {

	roster.stream()
	      .filter(p -> 18 <= p.getAge() && p.getAge() < 25)
	      .map(p -> p.getEmailAddress())
	      .forEach(email -> System.out.println(email));
    }

    private static void withoutLambda(List<Person> roster) {
	for (Person p : roster) {
	    if (18 <= p.getAge() && p.getAge() < 25) {
		String email = p.getEmailAddress();
		System.out.println(email);
	    }
	}
    }

}
