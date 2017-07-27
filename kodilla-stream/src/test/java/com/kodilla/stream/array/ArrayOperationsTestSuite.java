package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.Random;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        Random randGen = new Random();
        int[] array = new int[20];
        int arraySum = 0;
        for(int i=0;i<20;i++){
            array[i]=randGen.nextInt(100);
            arraySum+=array[i];
        }
        double average = (double) arraySum/array.length;

        //When
        OptionalDouble result = ArrayOperations.getAverage(array);
        //Then
        Assert.assertEquals(average,result.getAsDouble(),0.001);

    }
}
