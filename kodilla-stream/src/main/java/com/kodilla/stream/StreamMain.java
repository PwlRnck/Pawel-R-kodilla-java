package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forum.Forum;
import com.kodilla.stream.forum.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.person.People;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by PR on 21.07.2017.
 */
public class StreamMain {
    public static void main(String[] args) {

        /*PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println(poemBeautifier.beautify("abcd",a -> a.toUpperCase()));
        System.out.println(poemBeautifier.beautify("abcd",a -> "ABC" + a + "ABC"));
        System.out.println(poemBeautifier.beautify("abcd",a -> a.substring(0,1).toUpperCase()+a.substring(1,2)+a.substring(2,3).toUpperCase()+a.substring(3,4)));
        System.out.println(poemBeautifier.beautify("abcd",a -> new StringBuilder(a).reverse().toString()));
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);*/

        Forum forum = new Forum(20);

        Map<Integer,ForumUser> forumMap = forum.getUsersList().stream().filter(forumUser -> forumUser.getUserSex() == 'M').
                filter(forumUser -> forumUser.getAge()>=20).
                filter(forumUser -> forumUser.getPostsCount()>=1).
                collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser) );

        forumMap.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        }
}
