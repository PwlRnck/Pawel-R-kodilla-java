package com.kodilla.stream.beautifier;

/**
 * Created by PR on 23.07.2017.
 */
public class PoemBeautifier {
    public String beautify(String text, PoemDecorator poemDecorator){
        return poemDecorator.decorate(text);
    }
}
