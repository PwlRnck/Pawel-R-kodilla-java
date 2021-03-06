package com.kodilla.sudoku;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileReader {
    public List<String> readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/inputData.txt").getFile());

        try {
            List<String> fileLines = Files.readAllLines(Paths.get(file.getPath()));
            return fileLines;
        } catch (IOException e){
            throw new FileReaderException();
        }
    }
}
