package com.kren.yorberton.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.kren.yorberton.test.data.Album;
import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SampleData;

public class Ex1 {

    public static void main(String[] args) {

	IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	intStream = IntStream.of();
	System.out.println(addUp(intStream));

	List<Artist> artists = SampleData.membersOfTheBeatles;

	System.out.println(exB(artists));

	List<Album> albums = Arrays.asList(SampleData.aLoveSupreme, SampleData.sampleShortAlbum, SampleData.manyTrackAlbum);

	// Set<Album> moreThanThreeTracks =
	exC(albums).stream()
		   .forEach(album -> album.getTrackList()
					  .forEach(track -> System.out.println(track.getName())));

    }

    public static int addUp(IntStream numbers) {
	return numbers.sum();
    }

    public static Set<String> exB(List<Artist> artists) {
	return artists.stream()
		      .map(artist -> artist.getName() + " " + artist.getNationality())
		      .collect(Collectors.toSet());
    }

    public static Set<Album> exC(List<Album> albums) {
	return albums.stream()
		     .filter(album -> album.getTrackList()
					   .size() <= 3)
		     .collect(Collectors.toSet());
    }
}
