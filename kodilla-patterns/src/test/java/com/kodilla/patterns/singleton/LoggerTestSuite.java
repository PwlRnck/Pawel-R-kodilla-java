package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class LoggerTestSuite {
    @Test
    public void testLog() {
        //Given
        Logger logger = Logger.getInstance();
        //When
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        logger.log("test1");
        String output = os.toString();
        System.setOut(originalOut);
        //Then
        Assert.assertEquals("Log: [test1]" +  System.getProperty("line.separator"),output);
    }

    @Test
    public void testGetLastLog() {
        //Given
        Logger logger = Logger.getInstance();
        //When
        logger.log("test2");
        String result = logger.getLastLog();
        //Then
        Assert.assertEquals("test2",result);

    }
}
