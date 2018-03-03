package com.kren.yorberton.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SimpleData;

public class Ex2 {

    public static void main(String[] args) {
	List<Artist> artists = Arrays.asList(SimpleData.theBeatles, SimpleData.johnColtrane);

	beforeRefacroting(artists);
	afterRefacroting(artists);
    }

    static void beforeRefacroting(List<Artist> artists) {
	int totalMembers = 0;
	for (Artist artist : artists) {
	    Stream<Artist> members = artist.getMembers();
	    totalMembers += members.count();

	}

	System.out.println(totalMembers);
    }

    static void afterRefacroting(List<Artist> artists) {

	Long value = artists.stream()
			    .mapToLong(artist -> artist.getMembers()
						       .count())
			    .sum();

	System.out.println(value.intValue());
    }

}
