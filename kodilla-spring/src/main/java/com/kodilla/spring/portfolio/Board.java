package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;

public class Board {
    @Autowired
    private TaskList toDoList;
    @Autowired
    private TaskList inProgressList;
    @Autowired
    private TaskList doneList;

    public TaskList getToDoList(){
        return toDoList;
    }

    public TaskList getInProgressList(){
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
