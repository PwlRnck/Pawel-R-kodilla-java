package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void testMedianPublicationYear() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author1","Title1",1980,"A00001"));
        bookSet.add(new Book("Author2","Title2",1982,"A00002"));
        bookSet.add(new Book("Author3","Title3",1984,"A00003"));
        bookSet.add(new Book("Author4","Title4",1990,"A00001"));

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(median);
        assertEquals(median,1984);
    }
}
