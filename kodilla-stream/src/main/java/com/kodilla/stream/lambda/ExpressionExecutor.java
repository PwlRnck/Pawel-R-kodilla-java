package com.kodilla.stream.lambda;

/**
 * Created by PR on 23.07.2017.
 */
public class ExpressionExecutor {
    public double executeExpression(double a, double b, MathExpression mathExpression){
        return mathExpression.calculateExpression(a,b);
    }
}
