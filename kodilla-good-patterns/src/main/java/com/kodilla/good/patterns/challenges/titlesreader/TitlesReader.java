package com.kodilla.good.patterns.challenges.titlesreader;

import java.util.stream.Collectors;

public class TitlesReader {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String titles = movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
               // .reduce("",(conc,nextStr) -> conc = conc + "!" + nextStr);
                .map(String::toString)
                .collect(Collectors.joining("!","",""));
        System.out.println(titles);
    }
}
