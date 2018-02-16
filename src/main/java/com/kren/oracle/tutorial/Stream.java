package com.kren.oracle.tutorial;

import java.util.function.IntConsumer;

public class Stream {

    public static void main(String[] args) {
	showTotalAge();

	showTotalAgeWithReduce();

	showAverageAge();
    }

    private static void showTotalAge() {
	int totalAge = Person.roster.stream()
				    .mapToInt(Person::getAge)
				    .sum();

	System.out.println("total age: " + totalAge);
    }

    private static void showTotalAgeWithReduce() {
	int totalAge = Person.roster.stream()
				    .mapToInt(Person::getAge)
				    .reduce(0, (a, b) -> a + b);

	System.out.println("total age with reduce: " + totalAge);
    }

    private static void showAverageAge() {
	Averager averager = Person.roster.stream()
					 .filter(person -> person.getGender() == Person.Sex.MALE)
					 .mapToInt(Person::getAge)
					 .collect(Averager::new, Averager::accept, Averager::combine);

	System.out.println(averager);
	System.out.println("average age for male person: " + averager.average());
    }
}

class Averager implements IntConsumer {
    private int total = 0;
    private int count = 0;

    public double average() {
	return count > 0 ? ((double) total) / count : 0;
    }

    @Override
    public void accept(int age) {
	total += age;
	count++;
    }

    public void combine(Averager other) {
	total += other.total;
	count += other.count;
    }

    @Override
    public String toString() {
	return "Averager [total=" + total + ", count=" + count + "]";
    }

}