package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by PR on 18.07.2017.
 */
public class CollectionTestSuite {

    private static int testCaseNo = 0;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Start of test suite");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("End of test suite");
    }

    @Before
    public void before(){
        ++testCaseNo;
        System.out.println("Start of test case no. " + testCaseNo);
    }

    @After
    public void after(){
        System.out.println("End of test case no. " + testCaseNo);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> list = new ArrayList<>();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(list);
        //Then
        Assert.assertEquals(list, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> list = new ArrayList<>();
        Random generator = new Random();
        for(int i =0;i<20;i++){
            list.add(generator.nextInt(100));
        }
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(list);
        //Then
        boolean isEven = true;
        for(Integer number:result){
            isEven = isEven && (number % 2 ==0);
        }
        Assert.assertTrue(isEven);

    }
}
