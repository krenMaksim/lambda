package com.kren.yorberton.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kren.yorberton.test.data.Artist;
import com.kren.yorberton.test.data.SimpleData;

public class ExHard2 {

    private static List<Artist> artists = SimpleData.getThreeArtists();

    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    public static void main(String[] args) {
	List<Artist> artistNames = artists.stream()
					  .filter(artist -> artist.getName()
								  .contains("John"))
					  .collect(Collectors.toList());

	System.out.println(artistNames);

	artistNames = artists.stream()
			     .reduce(new <Artist>ArrayList(artists.size()), (list, artist) -> {
				 if (artist.getName()
					   .contains("John"))
				     list.add(artist.getName());

				 return list;
			     }, (listRight, listLeft) -> {
				 listLeft.addAll(listRight);
				 return listLeft;
			     });

	System.out.println(artistNames);

    }

}
