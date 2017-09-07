package com.kodilla.stream.lambda;

/**
 * Created by PR on 21.07.2017.
 */
public class ExecuteSaySomething implements Executor {

    @Override
    public void process() {
        System.out.println("This is an example text.");
    }
}
