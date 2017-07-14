package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

/**
 * Created by PR on 12.07.2017.
 */
public class TestingMain {
    public static void main(String[] args){

        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")){
            System.out.println("Class: SimpleUser; method: getUsername; test OK");
        } else {
            System.out.println("Class: SimpleUser; method: getUsername; Error!");
        }

        Calculator calculator = new Calculator();
        if(calculator.add(2,2)==2+2){
            System.out.println("Class: calculator; method: add; test OK");
        } else {
            System.out.println("Class: calculator; method: add; Error!");
        }

        if(calculator.subtract(5,2)==5-2){
            System.out.println("Class: calculator; method: subtract; test OK");
        } else {
            System.out.println("Class: calculator; method: subtract; Error!");
        }

    }
}
