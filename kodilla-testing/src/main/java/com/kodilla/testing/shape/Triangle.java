package com.kodilla.testing.shape;

/**
 * Created by PR on 20.07.2017.
 */
public class Triangle implements Shape{
    private String shapeName = "Triangle";
    private double sideLengthA;
    private double sideLengthB;
    private double sideLengthC;

    public Triangle(double sideLengthA, double sideLengthB, double sideLengthC ) {
        this.sideLengthA = sideLengthA;
        this.sideLengthB = sideLengthB;
        this.sideLengthC = sideLengthC;
    }

    public String getShapeName() {
        return shapeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (
                ((triangle.sideLengthA == sideLengthA) && (triangle.sideLengthB == sideLengthB) && (triangle.sideLengthC == sideLengthC))||
                ((triangle.sideLengthA == sideLengthB) && (triangle.sideLengthB == sideLengthC) && (triangle.sideLengthC == sideLengthA))||
                ((triangle.sideLengthA == sideLengthC) && (triangle.sideLengthB == sideLengthA) && (triangle.sideLengthC == sideLengthB))||
                ((triangle.sideLengthA == sideLengthA) && (triangle.sideLengthB == sideLengthC) && (triangle.sideLengthC == sideLengthB))||
                ((triangle.sideLengthA == sideLengthB) && (triangle.sideLengthB == sideLengthA) && (triangle.sideLengthC == sideLengthC))||
                ((triangle.sideLengthA == sideLengthC) && (triangle.sideLengthB == sideLengthB) && (triangle.sideLengthC == sideLengthA))
                )return true;
        return shapeName.equals(triangle.shapeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName.hashCode();
        temp = Double.doubleToLongBits(sideLengthA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideLengthB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideLengthC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getArea(){
        double p = (sideLengthA+sideLengthB+sideLengthC)/2;
        return Math.sqrt(p*(p-sideLengthA)*(p-sideLengthB)*(p-sideLengthC));

    }
}
