package com.kodilla.testing.shape;

import org.junit.*;

/**
 * Created by PR on 20.07.2017.
 */
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        System.out.println("Preparing to execute test #" + ++testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(new Square(1));
        //Then
        Assert.assertEquals(1,shapeCollector.figures.size());
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(1);
        shapeCollector.addFigure(square);
        //When
        boolean result = shapeCollector.removeFigure(1);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0,shapeCollector.figures.size());
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(1);
        shapeCollector.addFigure(square);
        //When
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(square,result);
    }

/*
    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(1);
        shapeCollector.addFigure(square);
        Circle circle = new Circle(1);
        shapeCollector.addFigure(circle);
        Triangle triangle = new Triangle(1,2,3);
        shapeCollector.addFigure(triangle);
        //When

        //Then
    }
*/

}
