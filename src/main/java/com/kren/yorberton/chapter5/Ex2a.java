package com.kren.yorberton.chapter5;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2a {
    static Supplier<Stream<String>> streamSupplier = () -> Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

    public static void main(String[] args) {
	withCollectors();
	withReduce();
    }

    static void withReduce() {
	String rezult = streamSupplier.get()
				      .reduce("", (val1, val2) -> {
					  if (val1.compareToIgnoreCase(val2) > 0) {
					      return val1;
					  } else {
					      return val2;
					  }
				      });

	System.out.println(rezult);
    }

    static void withCollectors() {
	String rezult = null;

	// It's very interesting! Why may I do like this? I don't undestand clearly.
	rezult = streamSupplier.get()
			       .collect(Collectors.maxBy(String::compareTo))
			       .get();

	System.out.println(rezult);

	rezult = streamSupplier.get()
			       .collect(Collectors.maxBy((val1, val2) -> val1.compareTo(val2)))
			       .get();

	System.out.println(rezult);
    }

}
