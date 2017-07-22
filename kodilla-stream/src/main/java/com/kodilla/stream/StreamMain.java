package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;

/**
 * Created by PR on 21.07.2017.
 */
public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println(poemBeautifier.beautify("abcd",a -> a.toUpperCase()));
        System.out.println(poemBeautifier.beautify("abcd",a -> "ABC" + a + "ABC"));
        System.out.println(poemBeautifier.beautify("abcd",a -> a.substring(0,1).toUpperCase()+a.substring(1,2)+a.substring(2,3).toUpperCase()+a.substring(3,4)));
        System.out.println(poemBeautifier.beautify("abcd",a -> new StringBuilder(a).reverse().toString()));
    }
}
