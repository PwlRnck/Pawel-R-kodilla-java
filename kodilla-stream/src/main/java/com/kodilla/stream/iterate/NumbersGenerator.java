package com.kodilla.stream.iterate;

/**
 * Created by PR on 23.07.2017.
 */
import java.util.stream.*;

public final class NumbersGenerator {
    public static void generateEven(int max) {
        Stream.iterate(1, n -> n + 1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}