package com.kren.shild;

public class GenericLambda {

    public static void main(String[] args) {

	Generic<String> generic = (n) -> n;
	System.out.println(generic.simpleMethod("hello"));

	Generic<Integer> genericTwo = (n) -> n;
	System.out.println(genericTwo.simpleMethod(5));

    }

}

@FunctionalInterface
interface Generic<T> {
    T simpleMethod(T value);

}
