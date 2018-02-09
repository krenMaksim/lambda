package com.kren.oracle.tutorial;

import java.util.ArrayList;
import java.util.List;

import io.codearte.jfairy.Fairy;

public class Person {
    public static List<Person> roster;
    static {
	roster = new ArrayList<>();

	for (int i = 0; i < 100; i++) {
	    Fairy fairy = Fairy.create();
	    io.codearte.jfairy.producer.person.Person testData = fairy.person();

	    String name = testData.getFirstName();
	    int age = testData.getAge();

	    Person.Sex gender = Person.Sex.MALE;

	    String emailAddress = testData.getEmail();
	    Person person = new Person(name, age, gender, emailAddress);
	    roster.add(person);
	}

    }

    public enum Sex {
	MALE, FEMALE
    }

    private String name;
    private int age;
    private Sex gender;
    private String emailAddress;

    public Person(String name, int age, Sex gender, String emailAddress) {
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.emailAddress = emailAddress;
    }

    public static List<Person> getRoster() {
	return roster;
    }

    public static void setRoster(List<Person> roster) {
	Person.roster = roster;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public Sex getGender() {
	return gender;
    }

    public void setGender(Sex gender) {
	this.gender = gender;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
	result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Person other = (Person) obj;
	if (age != other.age)
	    return false;
	if (emailAddress == null) {
	    if (other.emailAddress != null)
		return false;
	} else if (!emailAddress.equals(other.emailAddress))
	    return false;
	if (gender != other.gender)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    public void printPerson() {
	System.out.println(toString());
    }

    @Override
    public String toString() {
	return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", emailAddress=" + emailAddress + "]";
    }

}