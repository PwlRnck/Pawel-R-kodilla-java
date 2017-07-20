package com.kodilla.testing.shape;

/**
 * Created by PR on 20.07.2017.
 */
public class Circle implements Shape {
    private String shapeName = "Circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.radius, radius) != 0) return false;
        return shapeName.equals(circle.shapeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getArea(){
        return Math.PI* Math.pow(radius,2);
    }
}