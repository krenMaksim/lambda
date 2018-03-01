package com.kren.yorberton.chapter3;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.kren.yorberton.test.data.Album;
import com.kren.yorberton.test.data.SampleData;

public class RefactoringTest {

    private static List<Album> albums = unmodifiableList(asList(SampleData.aLoveSupreme, SampleData.sampleShortAlbum));

    private static Set<String> rezult = Collections.unmodifiableSet(Arrays.asList("Acknowledgement", "Resolution")
									  .stream()
									  .collect(Collectors.toSet()));

    @Test
    void findLongTracks() {

	Set<String> set = Refactoring.findLongTracks(albums);
	assertEquals(rezult, set);
    }
}
