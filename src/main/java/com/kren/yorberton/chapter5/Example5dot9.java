package com.kren.yorberton.chapter5;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SimpleData;

public class Example5dot9 {

    public static void main(String[] args) {
	varOne();
	varTwo();
    }

    static void varOne() {
	List<Artist> artists = SimpleData.getThreeArtists();

	Function<Artist, String> getArtistName = artist -> artist.getName();

	Map<String, List<Artist>> artistsByName = artists.stream()
							 .collect(Collectors.groupingBy(getArtistName));

	System.out.println(artistsByName);
    }

    static void varTwo() {

	Map<String, List<Artist>> artistsByName = SimpleData.getThreeArtists()
							    .stream()
							    .collect(Collectors.groupingBy(Artist::getName));

	System.out.println(artistsByName);
    }

}
