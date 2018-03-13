package com.kren.yorberton.chapter5;

import java.util.stream.Collectors;

import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SimpleData;

public class Example5dot12 {

    public static void main(String[] args) {
	varOne();
    }

    static void varOne() {

	String rezult = SimpleData.getThreeArtists()
				  .stream()
				  .map(Artist::getName)
				  .collect(Collectors.joining(" , ", "{", "}"));

	System.out.println(rezult);
    }

}
