package com.kren.yorberton.chapter4;

import java.util.List;
import java.util.Optional;

import com.kren.yorberton.test.data.Artist;

public class Ex3 {

    public static void main(String[] args) {

    }

}

class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
	this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
	if (index < 0 || index >= artists.size()) {
	    return Optional.empty();
	}
	return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
	Optional<Artist> artist = getArtist(index);

	// if (artist.isPresent()) {
	// return artist.get()
	// .getName();
	// } else {
	// return "unknown";
	// }

	// but better
	return artist.map(Artist::getName)
		     .orElse("unknown");

    }
}

// class Artists {
//
// private List<Artist> artists;
//
// public Artists(List<Artist> artists) {
// this.artists = artists;
// }
//
// public Artist getArtist(int index) {
// if (index < 0 || index >= artists.size()) {
// indexException(index);
// }
// return artists.get(index);
// }
//
// private void indexException(int index) {
// throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
// }
//
// public String getArtistName(int index) {
// try {
// Artist artist = getArtist(index);
// return artist.getName();
// } catch (IllegalArgumentException e) {
// return "unknown";
// }
// }
// }
