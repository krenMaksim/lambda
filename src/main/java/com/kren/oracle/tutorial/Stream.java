package com.kren.oracle.tutorial;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
	// showTotalAge();

	// showTotalAgeWithReduce();

	// showAverageAge();

	// showNamesOfMaleMambers();

	useGroupBy();
    }

    static void showTotalAge() {
	int totalAge = Person.roster.stream()
				    .mapToInt(Person::getAge)
				    .sum();

	System.out.println("total age: " + totalAge);
    }

    static void showTotalAgeWithReduce() {
	int totalAge = Person.roster.stream()
				    .mapToInt(Person::getAge)
				    .reduce(0, (a, b) -> a + b);

	System.out.println("total age with reduce: " + totalAge);
    }

    static void showAverageAge() {
	Averager averager = Person.roster.stream()
					 .filter(person -> person.getGender() == Person.Sex.MALE)
					 .mapToInt(Person::getAge)
					 .collect(Averager::new, Averager::accept, Averager::combine);

	System.out.println(averager);
	System.out.println("average age for male person: " + averager.average());
    }

    static void showNamesOfMaleMambers() {
	List<String> names = Person.roster.stream()
					  .filter(person -> person.getGender() == Person.Sex.MALE)
					  .map(person -> person.getName())
					  .collect(Collectors.toList());

	System.out.println(names);
    }

    static void useGroupBy() {
	Map<Person.Sex, List<Person>> map = Person.roster.stream()
							 .collect(Collectors.groupingBy(person -> person.getGender()));

	System.out.println(map);
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