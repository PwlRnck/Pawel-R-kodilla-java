package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;

public class TitlesReader {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String titles = movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .reduce("",(conc,nextStr) -> conc = conc + "!" + nextStr);

        System.out.println(titles.substring(1));
    }
}
