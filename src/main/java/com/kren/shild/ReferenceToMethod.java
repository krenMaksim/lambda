package com.kren.shild;

public class ReferenceToMethod {

    public static void main(String[] args) {

	hello(Test::hello);

	// Why can't we do this?
	// hello(ReferenceStaticMethod::helloTest);

	Test test = new Test();

	hello(test::helloFromObject);

    }

    private static void hello(ReferenceMethod method) {
	method.method();
    }

    public static void helloTest() {
	System.out.println("hello world!");
    }

}

class Test {
    public static void hello() {
	System.out.println("hello world!");
    }

    public void helloFromObject() {
	System.out.println("hello world from object!");
    }
}

@FunctionalInterface
interface ReferenceMethod {
    void method();

}
