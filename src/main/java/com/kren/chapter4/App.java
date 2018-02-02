package com.kren.chapter4;

import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {

	Logger log = new Logger();
	// log.example();
	// log.exampleWithLambda();

	log.debug(() -> "log value");

    }

}

class Logger {

    private boolean debug = true;

    public boolean isDebugEnabled() {
	return debug;
    }

    public void debug(String message) {
	if (isDebugEnabled()) {
	    System.out.println(message);
	}
    }

    public void example() {
	// BEGIN debug_optimised
	Logger logger = new Logger();
	if (logger.isDebugEnabled()) {
	    logger.debug("Look at this: " + expensiveOperation());
	}
	// END debug_optimised
    }

    private String expensiveOperation() {
	return "";
    }

    // BEGIN debug_lambda
    public void debug(Supplier<String> message) {
	if (isDebugEnabled()) {
	    debug(message.get());
	}
    }
    // END debug_lambda

    public void exampleWithLambda() {
	// BEGIN debug_optimised_lambda
	Logger logger = new Logger();
	logger.debug(() -> "Look at this: " + expensiveOperation());
	// END debug_optimised_lambda
    }

}
