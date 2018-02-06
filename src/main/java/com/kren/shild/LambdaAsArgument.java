package com.kren.shild;

public class LambdaAsArgument {

    public static void main(String[] args) {

	Arg arg = n -> {
	    n = n.toUpperCase();
	    System.out.println(n);
	};

	simpleMethod(arg);

	arg = n -> {
	    for (Character character : n.toCharArray()) {
		System.out.println(character);
	    }
	};

	simpleMethod(arg);

    }

    private static void simpleMethod(Arg arg) {
	String value = "hello world";

	arg.asArgumentMethod(value);
    }

}

@FunctionalInterface
interface Arg {
    void asArgumentMethod(String value);

}
