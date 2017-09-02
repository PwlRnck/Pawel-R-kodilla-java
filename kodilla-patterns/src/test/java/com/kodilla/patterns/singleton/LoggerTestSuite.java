package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testLog() {
        //Given
        Logger logger = Logger.getInstance();
        //When
        logger.log("test1");
        //Then

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
