package com.kren.yorberton.chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.kren.yorberton.test.data.Album;
import com.kren.yorberton.test.data.Track;

public class Refactoring {

    // step 3
    public static Set<String> findLongTracks(List<Album> albums) {

	Set<String> trackNames = albums.stream()
				       .flatMap(album -> album.getTrackList()
							      .stream())
				       .filter(track -> track.getLength() > 60)
				       .map(track -> track.getName())
				       .collect(Collectors.toSet());

	return trackNames;
    }

    // step 2
    public static Set<String> findLongTracks2(List<Album> albums) {
	Set<String> trackNames = new HashSet<>();

	albums.forEach(album -> {
	    album.getTrackList()
		 .stream()
		 .filter(track -> track.getLength() > 60)
		 .map(track -> track.getName())
		 .forEach(name -> trackNames.add(name));

	});

	return trackNames;
    }

    // step 1
    public static Set<String> findLongTracks1(List<Album> albums) {
	Set<String> trackNames = new HashSet<>();

	albums.forEach(album -> {
	    album.getTrackList()
		 .forEach(track -> {
		     if (track.getLength() > 60) {
			 String name = track.getName();
			 trackNames.add(name);
		     }
		 });
	});

	return trackNames;
    }

    // step 0
    public static Set<String> findLongTracks0(List<Album> albums) {
	Set<String> trackNames = new HashSet<>();
	for (Album album : albums) {
	    for (Track track : album.getTrackList()) {
		if (track.getLength() > 60) {
		    String name = track.getName();
		    trackNames.add(name);
		}
	    }
	}
	return trackNames;
    }
}
