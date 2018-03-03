package com.kren.yorberton.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SimpleData;

public class ExHard1 {

    private static List<Artist> artists = SimpleData.getThreeArtists();

    @SuppressWarnings({ "unused", "unchecked", "rawtypes" })
    public static void main(String[] args) {
	List<String> artistNames = artists.stream()
					  .map(artist -> artist.getName())
					  .collect(Collectors.toList());

	System.out.println(artistNames);

	artistNames = artists.stream()
			     .reduce(new <String>ArrayList(artists.size()), (list, artist) -> {

				 list.add(artist.getName());
				 return list;
			     }, (listRight, listLeft) -> {
				 listLeft.addAll(listRight);
				 return listLeft;
			     });

	System.out.println(artistNames);

    }

}
