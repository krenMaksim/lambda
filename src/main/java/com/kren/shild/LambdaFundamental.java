package com.kren.shild;

public class LambdaFundamental {

    public static void main(String[] args) {
	// without lambda

	Simple simple = new Simple() {

	    @Override
	    public void simpleMethod() {
		System.out.println("hello from simple method");
	    }
	};

	System.out.println(simple);
	simple.simpleMethod();

	// with lambda

	Simple sim = () -> System.out.println("hello from simple method");

	System.out.println(sim);
	sim.simpleMethod();

	SimpleTwo simpleTwo = (value) -> {
	    System.out.println("value: " + value);
	    return value;
	};

	simpleTwo.simpleMethod(100);

    }

}

@FunctionalInterface
interface Simple {
    void simpleMethod();

}

@FunctionalInterface
interface SimpleTwo {
    int simpleMethod(int value);

}