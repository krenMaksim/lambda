package com.kren.shild;

public class LambdaFundamental {

    public static void main(String[] args) {

	Simple simple = new Simple() {

	    @Override
	    public void simpleMethod() {
		System.out.println("hello from simple method");
	    }
	};

	System.out.println(simple);
	simple.simpleMethod();

	// example two with lambda

	Simple sim = () -> System.out.println("hello from simple method");

	System.out.println(sim);

	sim.simpleMethod();

	// Runnable

    }

}

@FunctionalInterface
interface Simple {
    void simpleMethod();

}
