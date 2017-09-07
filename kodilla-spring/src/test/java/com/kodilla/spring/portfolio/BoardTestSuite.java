package com.kodilla.spring.portfolio;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().addTask("toDoTask: task1");
        board.getInProgressList().addTask("inProgressTask: task2");
        board.getDoneList().addTask("doneTask: task3");
        //Then
        board.getToDoList().getTasks().stream().forEach(System.out::println);
        board.getInProgressList().getTasks().stream().forEach(System.out::println);
        board.getDoneList().getTasks().stream().forEach(System.out::println);
    }
}
