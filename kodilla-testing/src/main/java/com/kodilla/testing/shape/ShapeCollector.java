package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PR on 20.07.2017.
 */
public class ShapeCollector {

    List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape shape){
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        Shape result = null;
        if(n>=0 && n<figures.size()){
            result = figures.get(n);
        }
        return result;
    }

    public void showFigures(){
         for(Shape figure:figures){
             System.out.println(figure.getShapeName() + ": " + figure.getArea());
         }
    }
}
