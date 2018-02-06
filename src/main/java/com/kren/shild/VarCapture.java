package com.kren.shild;

public class VarCapture {

    public static void main(String[] args) {

	int value = 100;

	LambdaVarCapture capture = () -> {
	    int val = 1;
	    System.out.println(value + val);

	    // We can't do this
	    // value++;
	};

	// We can't do this
	// value++;

	capture.asArgumentMethod();

    }

}

@FunctionalInterface
interface LambdaVarCapture {
    void asArgumentMethod();

}
