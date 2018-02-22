package com.kren.oracle.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.codearte.jfairy.Fairy;

public class Exercises {

    public static void main(String[] args) {
	// exOne();

	exTwo();
    }

    static void exOne() {
	List<Person> roster = Person.roster;

	for (Person p : roster) {
	    if (p.getGender() == Person.Sex.MALE) {
		System.out.println(p.getName());
	    }
	}

	System.out.println("----------------------------------------------------------");

	roster.stream()
	      .filter(person -> person.getGender() == Person.Sex.MALE)
	      .forEach(person -> System.out.println(person.getName()));
    }

    static void exTwo() {
	List<Album> favs = new ArrayList<>();
	System.out.println(Album.albums);

	for (Album a : Album.albums) {
	    boolean hasFavorite = false;
	    for (Track t : a.tracks) {
		if (t.rating >= 4) {
		    hasFavorite = true;
		    break;
		}
	    }
	    if (hasFavorite)
		favs.add(a);
	}

	Collections.sort(favs, new Comparator<Album>() {
	    @Override
	    public int compare(Album a1, Album a2) {
		return a1.name.compareTo(a2.name);
	    }
	});

	System.out.println(favs);

	System.out.println("----------------------------------------------------------");

	favs = Album.albums.stream()
			   .sorted((albumOne, albumtwo) -> albumOne.name.compareTo(albumtwo.name))
			   .filter(album -> Arrays.asList(album.tracks)
						  .stream()
						  .anyMatch(track -> track.rating >= 4))
			   .collect(Collectors.toList());

	System.out.println(favs);
    }

}

class Album {
    public static List<Album> albums = new ArrayList<>();

    static {
	for (int i = 0; i < 10; i++) {
	    Fairy fairy = Fairy.create();
	    io.codearte.jfairy.producer.person.Person testData = fairy.person();

	    Track[] albumTracks = new Track[2];
	    for (int j = 0; j < albumTracks.length; j++) {
		albumTracks[j] = new Track();
		albumTracks[j].rating = testData.getAge();
	    }

	    String name = testData.getFirstName();

	    Album album = new Album();
	    album.name = name;
	    album.tracks = albumTracks;
	    albums.add(album);
	}
    }

    Track[] tracks;
    String name;

    @Override
    public String toString() {
	return "Album [tracks=" + Arrays.toString(tracks) + ", name=" + name + "]";
    }

}

class Track {
    int rating;

    @Override
    public String toString() {
	return "Track [rating=" + rating + "]";
    }

}
