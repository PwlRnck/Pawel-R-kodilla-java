package com.kodilla.patterns.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooksShallowCopy() {
        //Given
        Library library = new Library("Central Library");
        IntStream.iterate(1,n -> n+1)
                 .limit(5)
                 .forEach(n -> library.getBooks().add(new Book("Book#" + n,"Author#" + n,LocalDate.parse("2000-01-01"))));

        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Affiliate Library 1");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        shallowCopy.getBooks().add(new Book("New Book","New Author",LocalDate.parse("2017-01-01")));
        int result1 = library.getBooks().size();
        int result2 = shallowCopy.getBooks().size();

        //Then
        Assert.assertEquals(6,result1);
        Assert.assertEquals(6,result2);
        Assert.assertEquals(library.getBooks(),shallowCopy.getBooks());

    }

    @Test
    public void testGetBooksDeepCopy() {
        //Given
        Library library = new Library("Central Library");
        IntStream.iterate(1,n -> n+1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Book#" + n,"Author#" + n,LocalDate.parse("2000-01-01"))));

        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("Affiliate Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        deepCopy.getBooks().add(new Book("New Book","New Author",LocalDate.parse("2017-01-01")));
        int result1 = library.getBooks().size();
        int result3 = deepCopy.getBooks().size();

        //Then
        Assert.assertEquals(5,result1);
        Assert.assertEquals(6,result3);
        Assert.assertNotEquals(library.getBooks(),deepCopy.getBooks());
    }
}
