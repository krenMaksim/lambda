package com.kren.chapter3;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import com.kren.commonClasses.Album;

public class UnionOperation {

    public static void main(String[] args) {

	Album album = new Album("no name", Collections.emptyList(), Collections.emptyList());

	Set<String> origins = album.getMusicians()
				   .filter(artist -> artist.getName()
							   .startsWith("The"))
				   .map(artist -> artist.getNationality())
				   .collect(Collectors.toSet());

	System.out.println(origins);
    }

}
